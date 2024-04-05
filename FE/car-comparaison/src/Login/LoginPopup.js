import React , { useState, useRef } from 'react';
import './LoginPopup.css';
import "../global.css";

export default function LoginPopup({closePopup}) {
 const [email, setEmail] = useState('');
 const [password, setPassword] = useState('');
 const checkboxRef = useRef(null);
 const passwordRef = useRef(null);





 const handleEmail = (event) => {
    setEmail(event.target.value);
  };

  const handlePassword = (event) => {
    setPassword(event.target.value);
  };

  const handleCheckbox = () => {
    const checkboxElement = checkboxRef.current;
    const passwordElement = passwordRef.current;
    if (checkboxElement.checked) {
        passwordElement.type = 'text';
    } else {
        passwordElement.type = 'password';
    }
  };

  return (
    <div id='frame'>
      <div id='popup' className='content-box'>
        <div className='closeButtonContainer'>
      <button className='closePopup' onClick={closePopup}>&times;</button>
      </div>
      <div id='popupContentWrapper'>
      <div id='popupContent'>
      <div>
        <h2 className='titlePopup' style={{textAlign:'center'}}>Login</h2>
        </div>
        <div className='inputContainer'>
            <input className='input' placeholder="Email" onChange={handleEmail} value={email}></input>
            <input id='password' ref={passwordRef} className='input' type="password" placeholder="Password" onChange={handlePassword} value={password}></input>
            <div class='showPassword'>
                <p>Show Password</p>
                <input type='checkbox' ref={checkboxRef} onClick={handleCheckbox}></input>
            </div>
            </div>
            <div className='signButtons'>
        <button className='button' style={{width: '45%'}} >Sign Up</button>
        <button className='button' style={{width: '45%'}} >Sign In</button>
        </div>
      </div>
      </div>
    </div>
    </div>
  )
}
