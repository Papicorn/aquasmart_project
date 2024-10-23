import { useState } from 'react'
import LoginForm from './components/LoginForm';
import SignupForm from './components/SignupForm';


const App = () => {
  return (
    <div>
      <h1>My React App</h1>
      <LoginForm />
      <SignupForm />
    </div>
  );
};

export default App
