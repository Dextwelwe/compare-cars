import React , { useState } from 'react';
import './LoginPopup.css';
import "../global.css";

export default function LoginPopup({closePopup}) {
 const [isOpen, setIsOpen] = useState(false);

 const togglePopup = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div id='frame' >
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
            <input className='input' placeholder="Email"></input>
            <input className='input' placeholder="Password"></input>
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
