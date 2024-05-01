import React from 'react'
import  {useState, useEffect} from 'react'
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import arrowDown from '../images/caret-down-solid.svg'
import LoginPopup from '../Login/LoginPopup';
import { useLocation , useNavigate} from 'react-router-dom';
export default function Header({setUsername, username}) {
    const [isLoginOpen, setIsLoginOpen] = useState(false);
    const [isLogged, setIsLogged] = useState(false);
    const [isMain , setIsMain] = useState('true');
    const [isMenuOpen, setIsMenuOpen] = useState(false)
    const location = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
      sessionStorage.setItem("username", '');
     checkUrl()
    },[location.pathname]);

    function checkUrl(){
      setIsMenuOpen(false)
      if (location.pathname ==="/"){
        setIsMain(true);
      }else {
        setIsMain(false);
      }
    }
    const updateUser = (username) => {
        setUsername(username);
        sessionStorage.setItem("username", username);
        toast.success("Successfuly connected");
      };
      const toggleLoginPopup = () => {
        setIsLoginOpen(!isLoginOpen);
      }; 

      function setMenuOpen (){
        setIsMenuOpen(!isMenuOpen);
      }

      function signOut(){
        setUsername('')
        setIsLogged(false)
        setIsMenuOpen(false)
        toast.success("Signed off");
      }
  return (
    <div>
      <Toaster position="top-center" reverseOrder={false} toastOptions={{style: {fontFamily: 'Cairo'}}}/>
        {isLoginOpen && <LoginPopup closePopup={toggleLoginPopup} setUser={updateUser} setIsLogged={setIsLogged} />}
        <div className='header'>
            <h1 id='titleHeader'>Search & Compare Cars</h1>
            <div className='divButtonHeader'>
              { !isMain &&
            <button type='button' className='button' onClick={()=>navigate('/')}>Home</button>
              }
            <button type='button' className='button' onClick={()=>navigate('/compare')}>Compare</button>
            <button className='button'>Discover</button>
            {isLogged ? (
                 <><button className='button' type='button' onClick={setMenuOpen} style={{ gap: '2px' }}>{username} <span><img className='optionsUser' src={arrowDown}></img></span></button>
              { isMenuOpen &&
                <div className="dropdown-menu">
              <a href="#">Preferences</a>
              <a href="#" onClick={signOut}>Sign Out</a>
              </div>
              }
            </>) :
          (
           <button type='button' className='button' onClick={toggleLoginPopup}>Sign In </button> )}
            </div>
            </div>
    </div>
  )
}
