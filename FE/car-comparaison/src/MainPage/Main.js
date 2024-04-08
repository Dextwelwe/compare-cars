import React , {useState, useEffect, useRef} from 'react'
import "./main.css"
import "../global.css"
import LoginPopup from '../Login/LoginPopup';
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import {getMakes, getModelYear, getModels, getTrims} from './apiCalls';


export default function Main() {

  const [isLoginOpen, setIsLoginOpen] = useState(false);
  const [isLogged, setIsLogged] = useState(false);
  const [username, setUserName] = useState("");
  const [selectedYear, setSelectedYear]= useState("Year");
  const [selectedMake, setSelectedMake] = useState("Make");
  const [selectedModel, setSelectedModel] = useState("Model");
  const [selectedTrim, setSelectedTrim]= useState("Trim");
  const [makes, setMakes] = useState([])
  const [models, setModels] = useState([])
  const [years, setYears] = useState([])
  const [trims, setTrims] = useState([])
  const [isDisabled, setIsDisabled] = useState(true);
  const [isDisabledYear, setIsDisabledYear] = useState(true);
  const [isDisabledTrim, setIsDisabledTrim] = useState(true);
  const [isSearchDisabled, setIsSearchDisabled] = useState(true);

  useEffect(() => { 
   getMakes(setMakes)
    // eslint-disable-next-line
},[]);

  const toggleLoginPopup = () => {
    setIsLoginOpen(!isLoginOpen);
  }; 

  const updateUser = (username) => {
    setUserName(username);
    toast.success("Successfuly connected.");
  };

  function handleSelectModel(e){

  getModelYear(setYears, selectedMake, e.target.value);
  console.log(e.target.value)
  console.log(selectedModel)
    if (e.target.value !== selectedMake){
      setSelectedYear('Year')
      setSelectedTrim('Trim')
    }
    if (isDisabledYear){setIsDisabledYear(false)} ///else{ setIsDisabledYear(true); setSelectedYear('Year')}
    if (isDisabledTrim){setIsDisabledTrim(false)} //else{setIsDisabledTrim(true); setSelectedTrim('Trim')}
    
  setSelectedModel(e.target.value);
    } 
  
  function handleSelectYear(e){
  setSelectedYear(e.target.value);
  getTrims(setTrims, selectedMake, selectedModel, e.target.value);
  console.log(e.target.value)
  }

  function handleSelectedTrim(e){
    setSelectedTrim(e.target.value)
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
        <select name="year" disabled={isDisabledYear} value={selectedYear} onChange={handleSelectYear}>
        <option value="" >Year</option>
        {years.map((option, index) => (
          <option key={index} value={option}>{option}</option>
        ))}
        </select>
        <select name="trim" value={selectedTrim} disabled={isDisabledTrim} onChange={handleSelectedTrim} >
            <option value="audi">Trim</option>
            {trims.map((option, index) => (
          <option key={index} value={option}>{option}</option>
        ))}
        </select>
            <button className='button' style={{boxShadow : 'none', marginTop : '30px'}} disabled={isSearchDisabled}>Search</button>
        </div>
        </div>
    </div>
    <div id='footer'>Dextwelwe 2024</div>
   
    </div>
  )
}
