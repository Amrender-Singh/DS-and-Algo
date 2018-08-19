import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class Reader{
    BufferedReader br;
    StringTokenizer st;
    Reader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        if(st == null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());                
            } catch (Exception e) {
               return null;
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }
    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            
        }
        return str;
    }
}
class Project{
    int count;
    String name;
    Project(String name, int count){
        this.name = name;
        this.count = count;
    }
}

public class OpenSource{
    
    public static void readInputAndCreateMap(Reader sc, StringBuilder output){
        String s;
        while(!(s = sc.nextLine().trim()).equals("0")){
            HashMap<String, HashSet<String>> projectToStudent = new HashMap<>();
            HashMap<String, HashSet<String>> StudentToProject = new HashMap<>();
            while(!s.equals("1")){
                String student;
                HashSet<String> project = projectToStudent.get(s);
                if(project == null)
                    project = new HashSet<>();
                HashSet<String> studentSet;
                while((student = sc.nextLine().trim())!= null && !Character.isDigit(student.charAt(0)) && !Character.isUpperCase(student.charAt(0))){
                    project.add(student);
                    studentSet = StudentToProject.get(student);
                    if(studentSet == null)
                        studentSet = new HashSet<>();
                    studentSet.add(s);
                    StudentToProject.put(student, studentSet);
                }
                projectToStudent.put(s, project);
                s = student;
            }
            for(Map.Entry<String, HashSet<String>> entry :  StudentToProject.entrySet()){
                if(entry.getValue().size() > 1){
                    for(String project : entry.getValue()){
                        HashSet<String> set = projectToStudent.get(project);
                        set.remove(entry.getKey());
                        projectToStudent.put(project, set);
                    }
                }
            }
            ArrayList<Project> list = new ArrayList<>();
            for(Map.Entry<String, HashSet<String>> entry : projectToStudent.entrySet()){
                list.add(new Project(entry.getKey(), entry.getValue().size()));
            }
            Collections.sort(list,(a,b)->{
                if(b.count != a.count)
                    return b.count - a.count;
                return  a.name.compareTo(b.name); 
            });
            for(Project p : list){
                output.append(p.name +" "+p.count +"\n");
            }
        }
    }
    public static void main(String[] args) {
        Reader sc = new Reader();
        StringBuilder output = new StringBuilder();
        readInputAndCreateMap(sc, output);
        System.out.print(output.toString());
    }
}