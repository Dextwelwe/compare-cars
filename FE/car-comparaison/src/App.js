import Main from './MainPage/main.js';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CarView from './CarView/CarView.js'
import NotFoundPage from './NotFound.js'
import Header from './header/Header';

function App() {
  return (
    <Router>
      <Header></Header>   
      <Routes>
        <Route exact path="/"element={<Main></Main>} />
        <Route path="/cars/:id" element={<CarView></CarView>} />
        <Route path='*' element={<NotFoundPage></NotFoundPage>} />
        </Routes>
    </Router>
  );
}

export default App;
