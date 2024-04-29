import React , {useState, useEffect, useRef} from 'react'
import {getMakes, getModelYear, getModels, getTrims,getCarId} from './apiCalls';

export default function SearchBar({handle}) {
 

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
    

    useEffect(() => { 
        getMakes(setMakes)
         // eslint-disable-next-line
     },[]);
     
     
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
        let id = await getCarId(carId, selectedMake,selectedModel,selectedYear,selectedTrim);
        handle(id)
       }
     
       function handleSelectMake(e){
         setSelectedYear('Year')
         setSelectedTrim('Trim')
         setSelectedModel('Model')
         setIsDisabledYear(true)
         setIsDisabledTrim(true)
         if (e.target.value !== 'Make'){
         setSelectedMake(e.target.value)
         getModels(setModels,e.target.value);
         if (isDisabled){setIsDisabled(false)}
         }
         setIsSearchDisabled(true)
       }
  return (
    <div>
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
  )
}
