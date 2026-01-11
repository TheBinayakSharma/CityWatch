/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Civilian;
import Model.LoginCredentials;
import Model.Notice;
import Model.Organization;
import Model.StructuralStorage;
import Model.Task;
import java.util.Arrays;

/**
 * Class responsible for loading sample data into the system
 */
public class SampleData {

    /**
     * Populates the system with sample civilians, organizations, tasks,
     * notices, and login credentials for testing and demonstration purposes
     */
    public static void loadSampleData() {

        Civilian c1 = new Civilian("CIV-001", "Suman Shrestha", "Baneshwor, Kathmandu", "suman.shrestha@mail.com", "9801122334");
        Civilian c2 = new Civilian("CIV-002", "Priya Koirala", "Lalitpur, Kathmandu", "priya.koirala@mail.com", "9812233445");
        Civilian c3 = new Civilian("CIV-003", "Ramesh Adhikari", "Thamel, Kathmandu", "ramesh.adhikari@mail.com", "9823344556");
        Civilian c4 = new Civilian("CIV-004", "Anita Gurung", "Koteshwor, Kathmandu", "anita.gurung@mail.com", "9834455667");
        Civilian c5 = new Civilian("CIV-005", "Bikash Lama", "Maharajgunj, Kathmandu", "bikash.lama@mail.com", "9845566778");
        StructuralStorage.civilianStack.addAll(Arrays.asList(c1, c2, c3, c4, c5));
        StructuralStorage.updateCivilianArrayList();

        Organization o1 = new Organization("ORG-001", "GreenNepal", "9801112233", "contact@greennepal.org", "Putalisadak, Kathmandu");
        Organization o2 = new Organization("ORG-002", "Food4Nepal", "9811223344", "info@food4nepal.org", "New Baneshwor, Kathmandu");
        Organization o3 = new Organization("ORG-003", "EduNepal", "9822334455", "hello@edunepal.org", "Jhamsikhel, Lalitpur");
        Organization o4 = new Organization("ORG-004", "HealthNepal", "9833445566", "support@healthnepal.org", "Kalanki, Kathmandu");
        Organization o5 = new Organization("ORG-005", "CleanWaterNepal", "9844556677", "team@cleanwaternepal.org", "Boudha, Kathmandu");
        StructuralStorage.organizationStack.addAll(Arrays.asList(o1, o2, o3, o4, o5));
        StructuralStorage.updateOrganizationArrayList();

        Task u1 = new Task("Community Awareness", "Raise awareness about recycling");
        Task u2 = new Task("Neighborhood Survey", "Collect data on local waste management");
        Task u3 = new Task("Social Media Campaign", "Promote NGO initiatives online");
        Task u4 = new Task("Volunteer Recruitment", "Find and organize volunteers");
        Task u5 = new Task("Event Planning", "Plan NGO events and workshops");
        StructuralStorage.taskQueue.addAll(Arrays.asList(u1, u2, u3, u4, u5));
        StructuralStorage.updateTaskArrayList();

        Task ip1 = new Task("Tree Plantation", "Organize tree plantation drive in local parks");
        ip1.setAssignedTo(o1.getOrgId());
        Task ip2 = new Task("School Supplies Distribution", "Provide notebooks and stationery to students");
        ip2.setAssignedTo(o2.getOrgId());
        Task ip3 = new Task("Water Filter Installation", "Install water filters in schools and community areas");
        ip3.setAssignedTo(o3.getOrgId());
        Task ip4 = new Task("Community Cleanup", "Organize local neighborhood cleanup");
        ip4.setAssignedTo(o4.getOrgId());
        Task ip5 = new Task("Health Workshop", "Conduct health awareness workshops");
        ip5.setAssignedTo(o5.getOrgId());
        StructuralStorage.tasksInProgressArrayList.addAll(Arrays.asList(ip1, ip2, ip3, ip4, ip5));

        o1.getTaskAssigned().add(ip1);
        o2.getTaskAssigned().add(ip2);
        o3.getTaskAssigned().add(ip3);
        o4.getTaskAssigned().add(ip4);
        o5.getTaskAssigned().add(ip5);

        Task c1Task = new Task("Food Donation", "Collect and distribute food packages to families");
        c1Task.setAssignedTo(o2.getOrgId());
        c1Task.setCompletedBy(o2.getOrgId());
        Task c2Task = new Task("Free Health Camp", "Organize free health checkup camp");
        c2Task.setAssignedTo(o4.getOrgId());
        c2Task.setCompletedBy(o4.getOrgId());
        Task c3Task = new Task("Library Setup", "Set up small community library");
        c3Task.setAssignedTo(o3.getOrgId());
        c3Task.setCompletedBy(o3.getOrgId());
        Task c4Task = new Task("Tree Mapping", "Map trees in public parks");
        c4Task.setAssignedTo(o1.getOrgId());
        c4Task.setCompletedBy(o1.getOrgId());
        Task c5Task = new Task("Clean Water Awareness", "Educate about water hygiene");
        c5Task.setAssignedTo(o5.getOrgId());
        c5Task.setCompletedBy(o5.getOrgId());
        StructuralStorage.tasksCompletedArrayList.addAll(Arrays.asList(c1Task, c2Task, c3Task, c4Task, c5Task));

        o2.getTaskCompleted().add(c1Task);
        o4.getTaskCompleted().add(c2Task);
        o3.getTaskCompleted().add(c3Task);
        o1.getTaskCompleted().add(c4Task);
        o5.getTaskCompleted().add(c5Task);

        Notice n1 = new Notice("Community Cleanup", "Join the neighborhood cleanup drive this weekend");
        Notice n2 = new Notice("Tree Plantation Event", "Plant 500 trees in local parks");
        Notice n3 = new Notice("Food Distribution Camp", "Help distribute food packages to underprivileged families");
        Notice n4 = new Notice("Health Awareness Workshop", "Free workshop on hygiene and wellness for locals");
        Notice n5 = new Notice("Water Conservation Seminar", "Learn about saving water and installing filters in homes");
        StructuralStorage.noticeLinkedList.addAll(Arrays.asList(n1, n2, n3, n4, n5));
        StructuralStorage.updateNoticesArrayList();
        StructuralStorage.addRecentNotice(n1);
        StructuralStorage.addRecentNotice(n2);
        StructuralStorage.addRecentNotice(n3);
        StructuralStorage.addRecentNotice(n4);
        StructuralStorage.addRecentNotice(n5);

        LoginCredentials.civLoginCred.put(c1.getCivId(), "password");
        LoginCredentials.civLoginCred.put(c2.getCivId(), "password");
        LoginCredentials.civLoginCred.put(c3.getCivId(), "password");
        LoginCredentials.civLoginCred.put(c4.getCivId(), "password");
        LoginCredentials.civLoginCred.put(c5.getCivId(), "password");

        LoginCredentials.orgLoginCred.put(o1.getOrgId(), "password");
        LoginCredentials.orgLoginCred.put(o2.getOrgId(), "password");
        LoginCredentials.orgLoginCred.put(o3.getOrgId(), "password");
        LoginCredentials.orgLoginCred.put(o4.getOrgId(), "password");
        LoginCredentials.orgLoginCred.put(o5.getOrgId(), "password");
    }

}
