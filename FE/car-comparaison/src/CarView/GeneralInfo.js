import React from 'react'

export default function GeneralInfo({car}) {
  return (
    <div>
      <ul className='listINFO'>
      <li><span style={{fontWeight : "bold"}}>ENGINE</span>: {car.moteur}</li>
        <li><span style={{fontWeight : "bold"}}>FUEL TYPE : </span>{car.typeCarburant}</li>
        <li><span style={{fontWeight : "bold"}}>AUTONOMY : </span>{car.autonomie}</li>
        <li><span style={{fontWeight : "bold"}}>POWER : </span>{car.puissance}</li>
        <li><span style={{fontWeight : "bold"}}>TORQUE : </span>{car.couple}</li>
        <li><span style={{fontWeight : "bold"}}>TRANSMISSION : {car.transmission}</span></li>
        <li><span style={{fontWeight : "bold"}}>DRIVETRAIN : </span>{car.motricite}</li>
      </ul>
    </div>
  )
}
