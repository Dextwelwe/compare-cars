import React, {useEffect, useState} from 'react'
import engine from '../images/icons/engine.png'
import axle from '../images/icons/axle.png'
import battery from '../images/icons/battery.png'
import engine1 from '../images/icons/engine1.png'
import engineering from '../images/icons/engineering.png'
import gearbox from '../images/icons/gearbox.png'
import piston from '../images/icons/piston.png'
import pump from '../images/icons/pump.png'
import chassis from '../images/icons/chassis.png'
import fuel from '../images/icons/fuel.png'

export default function GeneralInfo({preferences,car}) {
  const defaultPreferences = ['ENGINE', 'FUELTYPE', 'POWER', 'TORQUE', 'TRANSMISSION', 'AUTONOMY'];
  const [prefs, setPrefs] = useState([])
  useEffect(() => {
   if (preferences.length > 1){
    setPrefs(setPreferences(preferences))
   }else {
    setPrefs(setPreferences(defaultPreferences));
   }
  })

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
    }
  }


  return (
    <div>
      { prefs.length > 0 &&
      <div>
<div style={{display:'flex', justifyContent : 'space-around', alignItems:'center', gap : '15px'}}>
  <div>
<img src={prefs[0].icon} width={40} height={40}></img>
<p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[0].value}</p>
</div>
<div>
<img src={prefs[1].icon} width={40} height={40}></img>
<p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[1].value}</p>
</div>
  
</div>

<div style={{display:'flex', justifyContent : 'space-around', alignItems:'center', gap : '15px'}}>
  <div >
<img src={prefs[2].icon} width={40} height={40}></img>
<p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[2].value}</p>
</div>
<div>
<img src={prefs[3].icon} width={40} height={40}></img>
<p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[3].value}</p>
</div>
  
</div>

<div style={{display:'flex', justifyContent : 'space-around', alignItems:'center', gap : '15px'}}>
  <div>
<img src={prefs[4].icon} width={40} height={40}></img>
<p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[4].value}</p>
</div>
<div>
<img src={prefs[5].icon} width={40} height={40}></img>
<p style={{fontSize : '18px', fontWeight : '600'}}>{prefs[5].value}</p>
</div>
  
</div>
</div>


}
    </div>
  )
}


<ul className='listINFO'>
{prefs.map((item, index) => (
  <div style={{display:'flex', justifyContent : 'flex-start', alignItems:'center', gap : '15px'}}>
  <img src={item.icon} width={40} height={40}></img>
  <p style={{fontSize : '18px', fontWeight : '600'}} key={index}>{item.value}</p>
  </div>
))}
</ul>