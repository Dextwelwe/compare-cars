import React, {useState, useEffect, useRef} from 'react'
import './PreferenceMenu.css'
import {getUserPreferences} from '../CarView/apiCalls.js'

export default function PreferenceMenu({closePopup, preferences, username}) {
    const defaultPreferences = ['ENGINE','FUELTYPE','POWER','TORQUE','TRANSMISSION','AUTONOMY'];
    const [nbSelected, setNbSelected] = useState(6);
    const [isError, setIsError] = useState(false)
    var prefs = useRef()
    
    const [preferencesView, setPreferencesView]= useState([ 
        {type : 'ENGINE', name : 'ENGINE', selected : 'N'},
        {type : 'FUELTYPE', name : 'FUEL TYPE', selected : 'N'},
        {type : 'POWER', name : 'POWER', selected : 'N'},
        {type : 'TORQUE', name : 'TORQUE', selected : 'N'},
        {type : 'TRANSMISSION', name : 'TRANSMISSION', selected : 'N'},
        {type : 'AUTONOMY', name : 'AUTONOMY', selected : 'N'},
        {type : 'MOTRICITY', name : 'MOTRICITY', selected : 'N'},
        {type : 'TYPE', name : 'TYPE', selected : 'N'},
        {type : 'FUELECONOMY', name : 'FUEL ECONOMY', selected : 'N'},
        {type : 'FUELECONOMYHWY', name : 'FUEL ECONOMY HIGHWAY', selected : 'N'},
        {type : 'MAXSPEED', name : 'MAX SPEED', selected : 'Y'}, 
])

    useEffect(() => {
        let preferences =  getUserPreferences(username, setPreferences);  
        setPreferences(preferences)
        initPreferenceView()
        // eslint-disable-next-line
  }, []);


    function setPreferences(preferences){
        if (preferences.length > 1){
            prefs.current = (preferences)
        } else {
            prefs.current = (defaultPreferences)
        }
      } 

      function getNumberSelectedItems(){
        let counter = 0;
        for (let x=0; x < preferencesView.length; x++){
            if (preferencesView[x].selected === 'Y'){
                counter++
            }
        }
        return counter;
      }

     function initPreferenceView(){
        let preferencesViewTMP = [...preferencesView];
        for (let i=0; i<preferencesViewTMP.length; i++){
            let elem = preferencesViewTMP[i];
            if (prefs.current.includes(elem.type)){
                elem.selected = 'Y';
            } else {
                elem.selected = 'N'
            }
        }
        setPreferencesView(preferencesViewTMP)
     } 

     function clear(){
        let preferencesViewTMP = [...preferencesView];
        preferencesViewTMP.forEach(element => {
            element.selected = 'N';
          });
         setPreferencesView(preferencesViewTMP)
         setNbSelected(getNumberSelectedItems)
         setIsError(false)
     }

     function select(item){
     let preferencesViewTMP = [...preferencesView];
     let el = preferencesViewTMP.find(element => element.type === item.type);
     if (el.selected === 'Y'){
        el.selected = 'N'
     } else {
        if (getNumberSelectedItems() < 6) {
        el.selected = 'Y'
        }
     }
    setPreferencesView(preferencesViewTMP)
    setNbSelected(getNumberSelectedItems)
     }

     function saveHandle(){
        if (getNumberSelectedItems() !== 6){
            setIsError(true)
            return;
        }
     let result = "";
     for (let x=0; x< preferencesView.length; x++){
        let el = preferencesView[x]
        if (el.selected === 'Y'){
         result += el.type + ";"   
        }
     }
     return result.slice(0,-1);
     }

  return (
    <div id='frame'>
      <div id='popup' style={{width:'50%'}} className='preferenceMenuContent content-box'>
      <div className='closeButtonContainer'>     
      <button className='closePopup' onClick={closePopup}>&times;</button>
      </div>
      <div id='popupContentWrapper'>
      <div id='popupContent'>
      <div>
      <h3 className='titlePopup' style={{textAlign:'center'}}>Select the general information to show in the car description</h3>
        </div>
        <div className='properties' id="preferenceMenuElements" style={{display:'flex', maxHeight : '500px', flexWrap:'wrap', justifyContent:'space-around', overflowY : 'auto' }}>
        {preferencesView.map((item, index) => (
            item.selected === 'N' ? (<p key={index} onClick={()=> select(item)} style={{backgroundColor: '#d9d9d9'}}>{item.name}</p>) : (<p key={index} onClick={()=> select(item)} style={{backgroundColor:'#B5C0D0'}}>{item.name}</p>)
      ))} 
        </div>
        <p style={{textAlign : 'end'}} > selected : <span style={{color : nbSelected < 6 ? 'red' : 'black'}}> { nbSelected } </span> / 6 </p>
        <p style={{color :'red', textAlign : 'center', marginBottom : "10px", visibility: !isError ? 'hidden' : 'visible' }}>Please select 6 elements*</p>
        <div style={{display:'flex', justifyContent:'center', marginBottom : '20px', gap :'20px'}}>
        <button className='button' onClick={clear}>CLEAR</button>
        <button className='button' onClick={saveHandle}>SAVE</button>
        </div>
        </div>
        </div>
      </div>
    </div>
  )
}
