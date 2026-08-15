public class Chatbot {

    public String getResponse(String question) {

        question = question.toLowerCase().trim();

        // Greeting
        if (question.equals("hi") ||
            question.equals("hello") ||
            question.equals("hey")) {

            return "Hello! Welcome to the GNIOT Student Support Chatbot. "
                    + "How can I help you?";
        }

        // Help
        if (question.equals("help")) {

            return "\nYou can ask me about:\n"
                   + "1. GNIOT information\n"
                   + "2. Location and contact\n"
                   + "3. Courses and CSE\n"
                   + "4. College timings\n"
                   + "5. Departments\n"
                   + "6. Library and hostel\n"
                   + "7. Placements\n"
                   + "8. Scholarships\n"
                   + "9. Student support\n"
                   + "10. Attendance\n"
                   + "11. Exams and timetable\n"
                   + "12. Assignments and leave\n"
                   + "13. Admission and eligibility\n"
                   + "14. Campus facilities\n"
                   + "15. Computer labs, transport, sports and medical facilities\n"
                   + "16. General questions using AI";
            }

        // GNIOT basic information
        if (question.contains("about gniot") ||
            question.contains("what is gniot") ||
            question.contains("about college") ||
            question.contains("about institute")) {

            return "Greater Noida Institute of Technology (GNIOT) is an "
                    + "engineering institute in Greater Noida. "
                    + "It was established in 2001 and is approved by AICTE "
                    + "and affiliated with Dr. A.P.J. Abdul Kalam Technical "
                    + "University (AKTU), Lucknow.";
        }

        // College code
        if (question.contains("college code") ||
            question.contains("gniot code")) {

            return "The College Code of Greater Noida Institute of Technology is 132.";
        }

        // Location
        if (question.contains("location") ||
            question.contains("where is gniot") ||
            question.contains("address")) {

            return "GNIOT is located at Plot No. 7, Knowledge Park-II, "
                    + "Greater Noida, Gautam Buddh Nagar, Uttar Pradesh - 201306.";
        }

        // Contact
        if (question.contains("contact") ||
            question.contains("phone") ||
            question.contains("telephone") ||
            question.contains("contact number")) {

            return "GNIOT contact numbers are 0120-2328214, "
                    + "0120-2328215 and 0120-2328216. "
                    + "The toll-free number is 18002746969.";
        }

        // Admission
        if (question.contains("admission") ||
            question.contains("admission process") ||
            question.contains("how to take admission") ||
            question.contains("how to apply")) {

            return "For admission-related information, GNIOT provides eligibility criteria, "
                   + "required documents, fee details and admission procedures on its official website. "
                   + "For admission enquiries, you can contact the GNIOT Admission Help Line "
                   + "at 8860606661/62/63 or email admission@gniot.net.in.";
        }

        // Admission Eligibility
        if (question.contains("eligibility") ||
            question.contains("btech eligibility") ||
            question.contains("eligibility for btech")) {

            return "For B.Tech admission, GNIOT states that candidates should have passed "
                   + "10+2 or an equivalent examination with Physics and Mathematics as "
                   + "compulsory subjects and the required optional subject. The minimum "
                   + "marks are 45% for general candidates and 40% for SC/ST candidates.";
        }

        // Courses
        if (question.contains("course") ||
            question.contains("courses") ||
            question.contains("degree") ||
            question.contains("degrees")) {

            return "GNIOT offers B.Tech programs in Computer Science and "
                    + "Engineering, CSE-IoT, CSE-AI & ML, Information Technology, "
                    + "ECE, Civil, Mechanical, Electrical, CSE-Data Science, "
                    + "CSE-AI, CSE-Cyber Security and AI & Data Science. "
                    + "It also offers M.Tech, MBA, MCA and Integrated BCA + MCA programs.";
        }

        // Computer Science
        if (question.contains("cse") ||
            question.contains("computer science")) {

            return "GNIOT offers B.Tech in Computer Science and Engineering "
                    + "and specialized programs including CSE-AI & ML, "
                    + "CSE-Data Science, CSE-AI and CSE-Cyber Security.";
        }

        // Timings
        if (question.contains("timing") ||
            question.contains("college time") ||
            question.contains("working hours")) {

            return "The institute timings listed by GNIOT are 9:00 AM to 5:00 PM.";
        }

        // Departments
        if (question.contains("department") ||
            question.contains("departments")) {

            return "GNIOT has departments including Computer Science and "
                    + "Engineering, Information Technology, CSE-AI & ML, "
                    + "CSE-Data Science, CSE-AI, ECE, Civil, Mechanical, "
                    + "Electrical, Applied Science and Humanities, Computer "
                    + "Applications, MBA, M.Tech and CSE-Cyber Security.";
        }

        // Facilities
        if (question.contains("facilities") ||
            question.contains("facility") ||
            question.contains("campus facilities")) {

            return "GNIOT provides several student facilities including a library, "
                   + "computer labs, hostel facilities, cafeteria, sports facilities, "
                   + "transportation and medical facilities. "
                   + "For current availability and timings, please check the official GNIOT website.";
        }

        // Computer Labs
if (question.contains("computer lab") ||
    question.contains("computer labs") ||
    question.contains("labs")) {

    return "GNIOT provides computer laboratory facilities for students. "
            + "For current lab availability, timings and rules, please contact "
            + "your department or check the official college notices.";
}

// Transport
if (question.contains("transport") ||
    question.contains("bus")) {

    return "GNIOT provides transportation facilities for students. "
            + "For current routes, timings and availability, please contact "
            + "the college administration.";
}

// Sports
if (question.contains("sports") ||
    question.contains("playground")) {

    return "GNIOT provides sports facilities for students. "
            + "For information about available sports, timings and facilities, "
            + "please check the official college information.";
}

// Medical
if (question.contains("medical") ||
    question.contains("health")) {

    return "GNIOT provides medical facilities for students. "
            + "For current medical support and timings, please contact "
            + "the college administration.";
}

        // Library
        if (question.contains("library")) {

            return "GNIOT provides a library facility for students. "
                    + "For current library timings, rules and other details, "
                    + "please check the official GNIOT website or library notice.";
        }

        // Hostel
        if (question.contains("hostel")) {

            return "GNIOT provides hostel facilities for students. "
                    + "For current hostel availability, fees and rules, "
                    + "please contact the college administration.";
        }

        // Placements
        if (question.contains("placement") ||
            question.contains("placements") ||
            question.contains("job")) {

            return "GNIOT has a placement and career support system for students. "
                    + "For current placement drives, recruiters and opportunities, "
                    + "please check the official GNIOT website.";
        }

        // Scholarships
        if (question.contains("scholarship") ||
            question.contains("scholarships")) {

            return "For scholarship information, students should check the "
                    + "official GNIOT website and current scholarship notices "
                    + "or contact the college administration.";
        }

        // Student support
        if (question.contains("student support") ||
            question.contains("student welfare") ||
            question.contains("student help")) {

            return "GNIOT provides student support through academic guidance, "
                    + "student welfare and other student-focused services. "
                    + "For specific support, please contact the concerned department.";
        }

        // Attendance
        if (question.contains("attendance") ||
            question.contains("attendence") ||
            question.contains("attendance requirement")) {

            return "According to GNIOT's examination policy, students must "
            + "maintain a minimum of 75% attendance in each theory paper "
            + "to be eligible to appear for the University Examination.";
        }

        // Exams
        if (question.contains("exam") ||
            question.contains("examination") ||
            question.contains("test")) {

            return "For examination schedules and results, please check the "
                    + "latest official GNIOT or AKTU examination notices and ERP.";
        }

        // Timetable
        if (question.contains("timetable") ||
            question.contains("time table") ||
            question.contains("schedule")) {

            return "For the latest class timetable, please check your "
                    + "department notice board or official student portal.";
        }

        // Assignments
        if (question.contains("assignment") ||
            question.contains("homework") ||
            question.contains("task")) {

            return "For assignment details, please contact your subject "
                    + "teacher or check the student portal.";
        }

        // Leave
        if (question.contains("leave") ||
            question.contains("absent")) {

            return "For leave-related requests, please follow your "
                    + "department's official leave procedure.";
        }

        // Website
        if (question.contains("website") ||
            question.contains("official website")) {

            return "The official GNIOT website is www.gniot.net.in.";
        }

        // Unknown question
        return "Sorry, I don't have that information yet. "
                + "You can ask me about GNIOT, courses, location, contact, "
                + "timings, departments, placements, scholarships or student support.";
    }
}