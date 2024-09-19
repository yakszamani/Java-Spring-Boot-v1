import React from 'react';
import ReactDOM from 'react-dom';
import StudentForm from './StudentForm';
import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  return (
    <div className="container">
      <div className="jumbotron mt-5">
        <h1 className="display-4">Student Registration</h1>
        <p className="lead">This is a simple student registration form built with React and Bootstrap.</p>
        <hr className="my-4" />
        <StudentForm />
      </div>
    </div>
  );
};

ReactDOM.render(
  <App />,
  document.getElementById('root')
);
