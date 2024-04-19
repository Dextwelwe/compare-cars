import React from 'react'

export default function GeneralInfo({car}) {
  return (
    <>
    <div>
      <ul className=''>
        {car.preferences.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
    </div>
    </>
  )
}
