import Main from './MainPage/main.js';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CarView from './CarView/CarView.js'
import NotFoundPage from './NotFound.js'
import Header from './header/Header';
import CompareView from './compare/CompareView.js';
import  { useState } from 'react';

function App() {
  const [username, setUsername] = useState('');

  return (
    <Router>
      <Header username={username} setUsername={setUsername}></Header>   
      <Routes>
        <Route exact path="/"element={<Main></Main>} />
        <Route path="/cars/:id" element={<CarView username={username}></CarView>} />
        <Route path="/compare" element={<CompareView></CompareView>} />
        <Route path='*' element={<NotFoundPage></NotFoundPage>} />
        </Routes>
    </Router>
  );
}

export default App;
