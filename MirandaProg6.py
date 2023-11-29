kevin = {"courseName": "Python",
        "creditHours": [3],
        "letterGrade": "B"
        }


jose = {"courseName": "Java",
         "creditHours": [3],
         "letterGrade": "B"
         }


matthew = {"courseName": "JavaScript",
         "creditHours": [3],
         "letterGrade": "B"
         }


jaydyn = {"courseName": "Swift",
        "creditHours":[3],
        "letterGrade": "B"
        }


tom = {"courseName": "Kotlin",
       "creditHours": [3],
       "letterGrade": "B"
       }


def get_average(marks):
    total_sum = sum(marks)
    total_sum = float(total_sum)
    return total_sum / len(marks)


def calculate_total_average(students):
    assignment = get_average(students["creditHours"])
    return (assignment)


def assign_letter_grade(score):
    if score >= 90:
        return "A"
    elif score >= 80:
        return "B"
    elif score >= 70:
        return "C"
    elif score >= 60:
        return "D"
    else:
        return "f"


def class_average_is(student_list):
    result_list = []

    for student in student_list:
        stud_avg = calculate_total_average(student)
        result_list.append(stud_avg)
        return get_average(result_list)


students = [kevin, jose, matthew, jaydyn, tom]

for i in students:
    print(i["courseName"])
    print("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=")
    print("Average marks of %s is : %s " % (i["courseName"],
                                            calculate_total_average(i)))

    print("Letter Grade of %s is : %s" % (i["courseName"],
                                          assign_letter_grade(calculate_total_average(i))))

    print()


class_av = class_average_is(students)

print("Class Average is %s" % (class_av))
print("Letter Grade of the class is %s "
      % (assign_letter_grade(class_av)))
