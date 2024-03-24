import React from 'react'
import "./main.css"

export default function Main() {
  return (
    <div className="topDiv">
        <div className='header'>
            <div className='divButtonHeader'>
            <button className='button'>DISCOVER</button>
            <button className='button'>SIGN IN</button>
            </div>
            </div>
    <div className='content'>
        <h1>SEARCH AND COMPARE CARS</h1>
    <div className='searchContainer'>
        <select name="car1" >
            <option value="" >Make</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
        <select name="car1">
            <option value="" >Model</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
        <select name="car1">
        <option value="" >Year</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
        <select name="car1">
            <option value="audi">Trim</option>
            <option value="bmw">BMW</option>
            <option value="mercedes">Mercedes</option>
        </select>
            <button className='button' style={{backgroundColor : "#FF204E"}}>SEARCH</button>
        </div>
    </div>
    </div>
  )
}
