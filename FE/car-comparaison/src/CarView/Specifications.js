import React from 'react'

export default function Specifications({car}) {
  return (
    <div>
      <ul className='listINFO' style={{fontSize : '17px'}}>
        <li><span style={{fontWeight : "bold"}}>ENGINE</span>: {car.moteur}</li>
        <li><span style={{fontWeight : "bold"}}>FUEL TYPE : </span>{car.typeCarburant}</li>
        <li><span style={{fontWeight : "bold"}}>AUTONOMY : </span>{car.autonomie}</li>
        <li><span style={{fontWeight : "bold"}}>POWER : </span>{car.puissance}</li>
        <li><span style={{fontWeight : "bold"}}>TORQUE : </span>{car.couple}</li>
        <li><span style={{fontWeight : "bold"}}>DRIVETRAIN : </span>{car.motricite}</li>
        <li><span style={{fontWeight : "bold"}}>INDUCTION : </span>{car.induction}</li>
        <li><span style={{fontWeight : "bold"}}>MAX SPEED : </span>{car.vitesseMaximale}</li>
        <li><span style={{fontWeight : "bold"}}>0-100 km/h : </span>{car.acceleration}</li>
        <li><span style={{fontWeight : "bold"}}>VEHICULE TYPE : </span>{car.typeCarroserie} </li>
        <li><span style={{fontWeight : "bold"}}>TRANSMISSION : </span>{car.transmission}</li>
        <li><span style={{fontWeight : "bold"}}>NUMBER OF DOORS : </span>{car.numPortes}</li>
        <li><span style={{fontWeight : "bold"}}>FUEL CONSUMPTION : </span>{car.economieCarburant}</li>
        <li><span style={{fontWeight : "bold"}}>FUEL CONSUMPTION HIGHWAY : </span>{car.economieCarburantAutoroute}</li>
        <li><span style={{fontWeight : "bold"}}>NUMBER OF DOORS : </span>{car.numPortes}</li>
        <li><span style={{fontWeight : "bold"}}>COLORS : </span>{car.couleurs}</li>
        <li><span style={{fontWeight : "bold"}}>SPECIAL CHARACTERISTICS : </span>{car.characteristiques}</li>
        
      </ul>
    </div>
  )
}
