import java.util.Scanner;

public class JobPortal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] jobs = new String[10];          // max 10 jobs
        String[] applications = new String[20];  // max 20 applications
        int jobCount = 0, appCount = 0;
        int choice;

        do {
            System.out.println("\n--- JOB PORTAL ---");
            System.out.println("1. Post Job");
            System.out.println("2. View Jobs");
            System.out.println("3. Apply for Job");
            System.out.println("4. View Applications");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: // Post job
                    if (jobCount < jobs.length) {
                        System.out.print("Enter Job Title: ");
                        jobs[jobCount] = sc.nextLine();
                        jobCount++;
                        System.out.println("Job posted!");
                    } else {
                        System.out.println("Job list full.");
                    }
                    break;

                case 2: // View jobs
                    if (jobCount == 0) {
                        System.out.println("No jobs available.");
                    } else {
                        System.out.println("\n--- JOB LIST ---");
                        for (int i = 0; i < jobCount; i++) {
                            System.out.println((i + 1) + ". " + jobs[i]);
                        }
                    }
                    break;

                case 3: // Apply for job
                    if (jobCount == 0) {
                        System.out.println("No jobs to apply for.");
                    } else if (appCount < applications.length) {
                        System.out.print("Enter Your Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Job Number: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        if (num > 0 && num <= jobCount) {
                            applications[appCount] = name + " applied for: " + jobs[num - 1];
                            appCount++;
                            System.out.println("Application submitted!");
                        } else {
                            System.out.println("Invalid job number.");
                        }
                    } else {
                        System.out.println("Applications full.");
                    }
                    break;

                case 4: // View applications
                    if (appCount == 0) {
                        System.out.println("No applications yet.");
                    } else {
                        System.out.println("\n--- APPLICATIONS ---");
                        for (int i = 0; i < appCount; i++) {
                            System.out.println((i + 1) + ". " + applications[i]);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
