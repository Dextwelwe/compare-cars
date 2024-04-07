import React , {useState} from 'react'
import "./main.css"
import "../global.css"
import LoginPopup from '../Login/LoginPopup';
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import logo from '../images/logo4.png'

export default function Main() {

  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [isLogged, setIsLogged] = useState(false);
  const [username, setUserName] = useState("");
 // const [make, setMake] = []

  const toggleLoginPopup = () => {
    setIsLoginOpen(!isLoginOpen);
  }; 

  const updateUser = (username) => {
    setUserName(username);
    toast.success("Successfuly connected.");
  };

  function handleMake(){
  }


  return (
    <div className="topDiv">
        <Toaster position="top-center" reverseOrder={false} toastOptions={{style: {fontFamily: 'Cairo'}}}/>
        {isLoginOpen && <LoginPopup closePopup={toggleLoginPopup} setUser={updateUser} setIsLogged={setIsLogged} />}
        <div className='header'>
            <h1 id='titleHeader'>Search & Compare Cars</h1>
            <div className='divButtonHeader'>
            <button className='button'>Discover</button>
            {isLogged ? (
                 <button className='button'>{username}</button>) :
           (<button className='button' onClick={toggleLoginPopup}>Sign In</button> )}
            </div>
            </div>
    <div className='content'>

    <div >
      <div className='searchContainer'>
      <h2 id='titleSelect' style={{ display:'inline'}}>Find a car</h2>
        <select name="car1" onClick={handleMake} >
            <option value="" >Make</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
        <select name="car1" disabled>
            <option value="" >Model</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
        <select name="car1" disabled>
        <option value="" >Year</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
        <select name="car1" disabled>
            <option value="audi">Trim</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
            <button className='button' style={{boxShadow : 'none', marginTop : '30px'}}>Search</button>
        </div>
        </div>
    </div>
    <div id='footer'>Dextwelwe 2024</div>
   
    </div>
  )
}
