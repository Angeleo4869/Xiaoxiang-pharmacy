import React from 'react';
import logo from './logo.svg';
import './App.css';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
	<h1>hello React</h1>
        <button onClick={ajaxtest}> sub</button>
      </header>
    </div>
  );
}
function ajaxtest(){
  fetch('http://localhost:8080/XiaoXiangPharmacy/TestAction.action', {
  method: 'post',
  headers:{
    "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
  },
  body:'AdminNumber=leo&AdminPassword=123456'
}).then(function(response) {
  return response.text();
}).then(function(T){
  console.log('Request succeeded with JSON response', T);
}).catch(function(error) {
	console.log('Request failed', error);
});
}
export default App;