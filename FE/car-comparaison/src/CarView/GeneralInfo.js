import React from 'react'

export default function GeneralInfo({preferences,car}) {
  return (
    <div>
      <ul className='listINFO'>
      {preferences.map((item, index) => (
        <li key={index}>{item}</li>
      ))}
      </ul>
    </div>
  )
}
