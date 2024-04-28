import React, {useEffect, useState} from 'react'
import engine from '../images/icons/engine5.png'
import axle from '../images/icons/axle.png'
import battery from '../images/icons/battery.png'
import engine1 from '../images/icons/engine.png'
import engineering from '../images/icons/engineering.png'
import gearbox from '../images/icons/gearbox.png'
import pump from '../images/icons/pump.png'
import chassis from '../images/icons/chassis.png'
import fuel from '../images/icons/fuel.png'
import maxspeed from '../images/icons/maxspeed.png'

export default function GeneralInfo({preferences,car}) {
  const defaultPreferences = ['ENGINE', 'FUELTYPE', 'POWER', 'TORQUE', 'TRANSMISSION', 'AUTONOMY'];
  const [prefs, setPrefs] = useState([])

  useEffect(() => {
   if (preferences.length > 1){
    setPrefs(setPreferences(preferences))
   }else {
    setPrefs(setPreferences(defaultPreferences));
   }
   // eslint-disable-next-line
  },[])

  function setPreferences(preferences){
    var preferencesList = [];
    for (let i =0; i < preferences.length; i++){
      var tmp = checkPreference(preferences[i])
      console.log(tmp)
      preferencesList.push({
        type : preferences[i],
        value : tmp[0],
        icon : tmp[1]
      })
    }
    return preferencesList;
  }

  function checkPreference(item){
    switch (item) {
      case 'ENGINE':
      return [car.moteur, engine1];
      case 'FUELTYPE':
        return [car.typeCarburant, pump];
      case 'POWER' :
         return [car.puissance, engine];
      case 'TORQUE' :
          return [car.couple,engineering];
      case 'TRANSMISSION' : 
          return [car.transmission, gearbox];
      case 'AUTONOMY' : 
          return [car.autonomie,battery];
      case 'MOTRICITY' :
          return [car.motricite,axle];
      case 'TYPE' :
          return [car.typeCarroserie, chassis];
      case 'FUELECONOMY' :
          return [car.economieCarburant, fuel];
      case 'FUELECONOMYHWY' :
          return [car.economieCarburantAutoroute,fuel];      
      case 'MAXSPEED' :
          return [car.maxspeed, maxspeed]; 
      default :
          return;         
    }
  }

  return (
    <div>
      { prefs.length > 0 &&
      <div className='listINFO' style={{margin : '15px'}}>
      <div style={{display:'flex', justifyContent : 'space-around', alignItems:'center', gap : '15px'}}>
        <div className='wrapperIcon'>
          <img src={prefs[0].icon} width={40} height={40} alt='0'></img>
          <p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[0].value}</p>
        </div>
        <div className='wrapperIcon'>
          <img src={prefs[1].icon} width={40} height={40}alt='1'></img>
          <p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[1].value}</p>
        </div>
      </div>

      <div style={{display:'flex', justifyContent : 'space-around', alignItems:'center', gap : '15px'}}>
          <div className='wrapperIcon'>
              <img src={prefs[2].icon} width={40} height={40} alt='2'></img>
              <p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[2].value}</p>
          </div>
          <div className='wrapperIcon'>
              <img src={prefs[3].icon} width={40} height={40} alt='3'></img>
              <p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[3].value}</p>
          </div>
      </div>

      <div style={{display:'flex', justifyContent : 'space-around', alignItems:'center', gap : '15px'}}>
        <div className='wrapperIcon'>
          <img src={prefs[4].icon} width={40} height={40} alt='4'></img>
          <p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[4].value}</p>
        </div>
        <div className='wrapperIcon'>
          <img src={prefs[5].icon} width={40} height={40} alt='5'></img>
          <p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[5].value}</p>
        </div>
      </div>
      </div>
        }
  </div>
  )
}
