import React from 'react';
import Welcome from './ES6Clare';
import Container from './PersonCenter/drawer';
import Login from './LoginAndRegiter/Container/LoginPage';
import Register from './LoginAndRegiter/Container/RegisterPage';
import GoodsDetails from './GoodsDetails/gooddetails';
import ImedPurchases from './PuerchaseAndPay/ImediyPurchase';
import Data from './GlobalData';
// import App from './PersonCenter/PersonCenter.jsx';
// import App from './GoodsDetails/gooddetails';
// import App from './GoodsDetails/rotate/TgetData';
// import App from './Ftest'
 import App from './Test/C_badge';

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
        <Route path="/GoodsDetails">
          <GoodsDetails />
        </Route>
        <Route path="/ImedPurchase">
          <ImedPurchases />
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
    return(<RootRouter />)
    // return(
    //   <div>
    //     <App B_num={Data.Bnum} inv="true"/>
    //   </div>)
  };
}