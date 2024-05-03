import React from 'react'
import "./main.css"
import "../global.css"
import SearchBar from '../SearchBar/SearchBar';
import { useNavigate} from 'react-router-dom';
import Footer from '../footer/Footer';


export default function Main() { 
  const navigate = useNavigate();
  
const handleRedirect = (id) => {
   navigate('/cars/' + id);
}

  return (
    <>
    <div className="topDiv">
    <div className='content'>
    <SearchBar handle={handleRedirect}></SearchBar>
    </div>
    </div>
    <Footer></Footer>
    </>
  )
}
