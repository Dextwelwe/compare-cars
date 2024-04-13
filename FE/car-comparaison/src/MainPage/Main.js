import React , {useState, useEffect, useRef} from 'react'
import "./main.css"
import "../global.css"
import LoginPopup from '../Login/LoginPopup';
import {Toaster} from "react-hot-toast";
import {toast} from "react-hot-toast";
import {getMakes, getModelYear, getModels, getTrims,getCarId} from './apiCalls';
import arrowDown from '../images/caret-down-solid.svg'
import { useNavigate} from 'react-router-dom';


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
  const carId = useRef()
  const navigate = useNavigate();


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

  function handleSelectMake(e){
      setSelectedYear('Year')
      setSelectedTrim('Trim')
  }

  function handleSelectModel(e){
  getModelYear(setYears, selectedMake, e.target.value);
    setIsDisabledTrim(true)
    setIsDisabledYear(false)
    if (e.target.value !== selectedMake){
      setSelectedYear('Year')
      setSelectedTrim('Trim')
      setIsSearchDisabled(true)
    }
  setSelectedModel(e.target.value);
    } 
  
  function handleSelectYear(e){
  getTrims(setTrims, selectedMake, selectedModel, e.target.value);
  setIsDisabledTrim(false)
  if (e.target.value !== selectedYear){
    setSelectedTrim('Trim')
  }
  setSelectedYear(e.target.value);
  setIsSearchDisabled(false)
  }

  function handleSelectedTrim(e){
    setSelectedTrim(e.target.value)
  }

  async function handleCarSearch(){
    await getCarId(carId, selectedMake,selectedModel,selectedYear,selectedTrim);
    navigate('/cars/' + carId.current);
  }

  function handleSelectMake(e){
    setSelectedYear('Year')
    setSelectedTrim('Trim')
    setSelectedModel('Model')
    setIsDisabledYear(true)
    setIsDisabledTrim(true)
    console.log(e.target.value)
    if (e.target.value !== 'Make'){
    setSelectedMake(e.target.value)
    getModels(setModels,e.target.value);
    if (isDisabled){setIsDisabled(false)}
    }
    setIsSearchDisabled(true)
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
                 <button className='button' type='button' style={{gap : '5px'}}>{username} <span><img className='optionsUser' src={arrowDown}></img></span></button>) :
          (
           <button type='button' className='button' onClick={toggleLoginPopup}>Sign In </button> )}
            </div>
            </div>
    <div className='content'>

    <div >
      <div className='searchContainer'>
      <h2 id='titleSelect' style={{ display:'inline'}}>Find a car</h2>
        <select name="make"  onChange={handleSelectMake} defaultValue={"Make"} >
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
            <button id="searchButton" className='button' style={{boxShadow : 'none', marginTop : '30px'}} disabled={isSearchDisabled} onClick={handleCarSearch}>Search</button>
        </div>
        </div>
    </div>
    <div id='footer'>Dextwelwe 2024</div>
   
    </div>
  )
}
