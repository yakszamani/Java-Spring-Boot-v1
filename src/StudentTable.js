import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const StudentTable = ({ students }) => {
  return (
    <table className="table table-striped">
      <thead className="thead-dark">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        {students.map(student => (
          <tr key={student.id}>
            <td>{student.id}</td>
            <td>{student.studentName}</td>
            <td>{student.studentEmail}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default StudentTable;
