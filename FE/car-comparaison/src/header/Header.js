import React from 'react'
import  {useState, useEffect} from 'react'
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import arrowDown from '../images/caret-down-solid.svg'
import LoginPopup from '../Login/LoginPopup';
import { useLocation , useNavigate} from 'react-router-dom';
import PreferenceMenu from '../PreferenceMenu/PreferenceMenu';
export default function Header({setUsername, username, updateCarView, setUpdateCarView}) {
    const [isLoginOpen, setIsLoginOpen] = useState(false);
    const [isLogged, setIsLogged] = useState(false);
    const [isMain , setIsMain] = useState('true');
    const [isMenuOpen, setIsMenuOpen] = useState(false)
    const [isPreferenceOpen, setIsPreferenceOpen] = useState(false)

    const location = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
      sessionStorage.setItem("username", '');
     checkUrl()
     // eslint-disable-next-line
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

      function setIsPreferenceMenuOpen(){
        setIsMenuOpen(false);
        setIsPreferenceOpen(!isPreferenceOpen);
      }


      function signOut(){
        setUsername('')
        setIsLogged(false)
        setIsMenuOpen(false)
        toast.success("Signed off");
      }
  return (
    <div>
      {isPreferenceOpen && <PreferenceMenu set={setUpdateCarView} valueCarView={updateCarView} closePopup={setIsPreferenceMenuOpen} username={username}> </PreferenceMenu>}
      <Toaster position="top-center" reverseOrder={false} toastOptions={{style: {fontFamily: 'Cairo', zIndex: '9999'}}}/>
        {isLoginOpen && <LoginPopup closePopup={toggleLoginPopup} setUser={updateUser} setIsLogged={setIsLogged} />}
        <div className='header'>
            <h1 id='titleHeader'>Search & Compare Cars</h1>
            <div className='divButtonHeader'>
              { !isMain &&
            <button type='button' className='button' onClick={()=>navigate('/')}>Home</button>
              }
            <button type='button' className='button' onClick={()=>navigate('/compare')}>Compare</button>
            {isLogged ? (
                 <><button className='button' type='button' onClick={setMenuOpen} style={{ gap: '2px' }}>{username} <span><img className='optionsUser' alt="arrow Down" src={arrowDown}></img></span></button>
              { isMenuOpen &&
                <div className="dropdown-menu">
              <button  onClick={setIsPreferenceMenuOpen}>Preferences</button>
              <button  onClick={signOut}>Sign Out</button>
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
