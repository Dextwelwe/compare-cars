import React , {useState, useEffect, useRef} from 'react'
import "./main.css"
import "../global.css"
import LoginPopup from '../Login/LoginPopup';
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import {getMakes, getModelYear, getModels} from './apiCalls';


export default function Main() {

  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [isLogged, setIsLogged] = useState(false);
  const [username, setUserName] = useState("");
  const [selectedMake, setSelectedMake] = useState("");
  const [selectedModel, setSelectedModel] = useState("Model");
  const [makes, setMakes] = useState([])
  const [models, setModels] = useState([])
  const [years, setYears] = useState([])
  const [isDisabled, setIsDisabled] = useState(true);
  const [isDisabledYear, setIsDisabledYear] = useState(true);

  useEffect(() => { 
   handleMake()
    // eslint-disable-next-line
},[]);

  const toggleLoginPopup = () => {
    setIsLoginOpen(!isLoginOpen);
  }; 

  const updateUser = (username) => {
    setUserName(username);
    toast.success("Successfuly connected.");
  };

  function handleMake(){
    getMakes(setMakes);
  }

  function handleSelectModel(e){
    console.log("ab")
  setSelectedModel(e.target.value);
  getModelYear(setYears, selectedMake, e.target.value);
  if (isDisabledYear){setIsDisabledYear(false)}
    } 
  

  function handleModel(e){
    console.log(e.target.value)
    if (e.target.value !== 'Make'){
    setSelectedMake(e.target.value)
    getModels(setModels,e.target.value);
    if (isDisabled){setIsDisabled(false)}
    setSelectedModel('Model')
    }
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
        <select name="make"  onChange={handleModel} defaultValue={"Make"} >
        <option value="Make" disabled>Make</option>
        {makes.map((option, index) => (
          <option key={index} value={option}>{option}</option>
        ))}
        </select>
        <select id='model' name="model" disabled={isDisabled} value={selectedModel} onChange={handleSelectModel} >
        <option value="Model" disabled>Model</option>
        {models.map((option, index) => (
          <option key={index} value={option}>{option}</option>
        ))}
        </select>
        <select name="car1" disabled={isDisabledYear}>
        <option value="" >Year</option>
        {years.map((option, index) => (
          <option key={index} value={option}>{option}</option>
        ))}
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
