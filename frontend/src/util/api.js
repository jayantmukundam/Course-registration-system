export const api = {
    getAllDepartments: `http://localhost:8080/api/department/get-all`,
    registrationUrl: 'http://localhost:8080/api/employee/add',
    getCourses: (id) => {
        console.log(id);
        return String(`http://localhost:8080/api/course_schedule/${Number(id)}/get`)
    }
}


