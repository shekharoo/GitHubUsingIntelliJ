package DoubleArray;

public class DataProviderWithoutTestNG {
    public void createProjectTest(String actAPIProjectNAme, String projectStatus) throws Throwable {

        Project pObj = new Project(actAPIProjectNAme, projectStatus);
        System.out.println("=======Values=======");
        System.out.println("ProjectName: "+actAPIProjectNAme);
        System.out.println("projectStatus: "+projectStatus);

    }
    public static void main(String[] args) {
//        Project p =new Project("ABC","XYZ");
//        System.out.println("project Name: "+p.getActAPIProjectNAme());
//        System.out.println("Project Status: "+p.getProjectStatus());

    }
}
