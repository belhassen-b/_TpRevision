import './App.css'
import ListPlantComponent from './components/ListPlantComponent.jsx'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import TodoComponent from './components/PlantComponent.jsx'
import RegisterComponent from './components/RegisterComponent'
import LoginComponent from './components/LoginComponent'
import { isUserLoggedIn } from './services/AuthService'

function App() {

  function AuthenticatedRoute({children}){

    const isAuth = isUserLoggedIn();

    if(isAuth) {
      return children;
    }

    return <Navigate to="/" />

  }

  return (
    <>
    <BrowserRouter>
        <HeaderComponent />
          <Routes>
              {/* http://localhost:8080 */}
              <Route path='/' element = { <LoginComponent /> }></Route>
               {/* http://localhost:8080/plants */}
              <Route path='/plants' element = {
              <AuthenticatedRoute>
                <ListPlantComponent />
              </AuthenticatedRoute> 
              }></Route>
              {/* http://localhost:8080/add-plant */}
              <Route path='/add-plant' element = {
                <AuthenticatedRoute>
                <TodoComponent /> 
                </AuthenticatedRoute>
              }></Route>
              {/* http://localhost:8080/update-plant/1 */}
              <Route path='/update-plant/:id' element = {
              <AuthenticatedRoute>
              <TodoComponent /> 
              </AuthenticatedRoute>
              }></Route>
               {/* http://localhost:8080/register */}
              <Route path='/register' element = { <RegisterComponent />}></Route>

               {/* http://localhost:8080/login */}
               <Route path='/login' element = { <LoginComponent /> }></Route>

          </Routes>
        <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
