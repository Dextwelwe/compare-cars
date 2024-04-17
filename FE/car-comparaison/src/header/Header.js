import React from 'react'
import  {useState, useEffect, useRef} from 'react'
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import arrowDown from '../images/caret-down-solid.svg'
import LoginPopup from '../Login/LoginPopup';
export default function Header() {

    const [isLoginOpen, setIsLoginOpen] = useState(false);
    const [isLogged, setIsLogged] = useState(false);
    const [username, setUserName] = useState("");
    const updateUser = (username) => {
        setUserName(username);
        toast.success("Successfuly connected.");
      };
      const toggleLoginPopup = () => {
        setIsLoginOpen(!isLoginOpen);
      }; 
  return (
    <div>
      <Toaster position="top-center" reverseOrder={false} toastOptions={{style: {fontFamily: 'Cairo'}}}/>
        {isLoginOpen && <LoginPopup closePopup={toggleLoginPopup} setUser={updateUser} setIsLogged={setIsLogged} />}
        <div className='header'>
            <h1 id='titleHeader'>Search & Compare Cars</h1>
            <div className='divButtonHeader'>
            <button className='button'>Discover</button>
            {isLogged ? (
                 <button className='button' type='button' style={{gap : '5px'}}>{username} <span><img className='optionsUser' src={arrowDown}></img></span></button>) :
          (
           <button type='button' className='button' onClick={toggleLoginPopup}>Sign In </button> )}
            </div>
            </div>
    </div>
  )
}
