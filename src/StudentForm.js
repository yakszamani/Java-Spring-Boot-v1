import React, { useState } from 'react';
import axios from 'axios';
import StudentTable from './StudentTable';

const StudentForm = () => {
  const [studentName, setStudentName] = useState('');
  const [studentEmail, setStudentEmail] = useState('');
  const [students, setStudents] = useState([]);
  const [result, setResult] = useState('');

  const handleAddStudent = () => {
    axios.post('http://localhost:8080/registerstudent', {
        studentName: studentName,
        studentEmail: studentEmail
    }).then(response => {
      console.log(response);
      // Set the result state to the response data
      setResult(response.data);
    }).catch(error => {
      console.log(error);
    });
  };

  const handleDisplayStudents = () => {
    axios.get('http://localhost:8080/allstudents').then(response => {
      setStudents(response.data);
    }).catch(error => {
      console.log(error);
    });
};

return (
  <div>
    <label>Student Name:</label>
    <input type="text" name="studentName" value={studentName} onChange={e => setStudentName(e.target.value)} />

    <label>Student Email:</label>
    <input type="text" name="studentEmail" value={studentEmail} onChange={e => setStudentEmail(e.target.value)} />

    <button onClick={handleAddStudent}>Add Student</button>
    <button onClick={handleDisplayStudents}>Display Students</button>

    <StudentTable students={students} />

        {/* Display the result */}
    {result && (
    <p>The student with name {result.studentName} and email {result.studentEmail} was successfully registered.</p>
    )}

  </div>
);
};

export default StudentForm;

