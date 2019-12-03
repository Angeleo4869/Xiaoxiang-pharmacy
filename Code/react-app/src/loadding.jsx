import React from 'react';
import Welcome from './ES6Clare';
import Container from './PersonCenter/drawer';
import Login from './LoginAndRegiter/Container/LoginPage';
import Register from './LoginAndRegiter/Container/RegisterPage';
// import App from './PersonCenter/PersonCenter.jsx';
// import App from './GoodsDetails/gooddetails';
import App from './GoodsDetails/rotate/TgetData';
// import App from './GoodsDetails/Tabs';
import {
    BrowserRouter as Router,
    Switch,
    Route,
  } from 'react-router-dom';

function RootRouter() {
  return (
      <Router>
          <div id="foodd"></div>
      <Switch >
        <Route exact path="/" children={<Welcome />} />
        <Route path="/PersonCenter">
          <Container />
        </Route>
        <Route path="/Login">
          <Login />
        </Route>
        <Route path="/Register">
          <Register />
        </Route>
      </Switch>      
      </Router>
  );
}

export default class classConponent extends React.Component{
  componentWillMount () {
    // loading 动画 的结束 控制 模块
    let loading = document.getElementById('i-loading')
    if (loading) {
      loading.setAttribute('class', 'i-loading-out')
      setTimeout(() => {
        loading.style.display = 'none'
      }, 1000)
    }
  }
  render(){
    // return(<RootRouter />)
    return(<App />)
  };
}