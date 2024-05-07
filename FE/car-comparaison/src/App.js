
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Main from './MainPage/Main.js';
import CarView from './CarView/CarView.js'
import NotFoundPage from './NotFound.js'
import Header from './header/Header';
import CompareView from './compare/CompareView.js';
import  { useState } from 'react';

function App() {
  const [username, setUsername] = useState('');
  const [updateView, setUpdateView] = useState(true)

  return (
    <Router>
      <Header username={username} setUsername={setUsername} updateCarView={updateView} setUpdateCarView={setUpdateView}></Header>   
      <Routes>
        <Route exact path="/"element={<Main></Main>} />
        <Route path="/cars/:id" element={<CarView username={username} changes={updateView}></CarView>} />
        <Route path="/compare" element={<CompareView></CompareView>} />
        <Route path='*' element={<NotFoundPage></NotFoundPage>} />
        </Routes>
    </Router>
  );
}

export default App;
