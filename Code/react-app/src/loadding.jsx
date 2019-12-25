import React from 'react';
import Test from './ES6Clare';

// import Welcome from './MainInterface/collect';
import Container from './PersonCenter/drawer';
import Login from './LoginAndRegiter/Container/LoginPage';
import Register from './LoginAndRegiter/Container/RegisterPage';
import GoodsDetails from './GoodsDetails/gooddetails';
import ImedPurchases from './PuerchaseAndPay/ImediyPurchase';
import Management from './BGManagement/BGMainInterface/bgmgmn';
import Shop from './BGManagement/ShopManage/ShopManagement';
import ShopView from './ExhibitShow/ShopShow/shopshow';
// import App from './PersonCenter/PersonCenter.jsx';
// import App from './GoodsDetails/gooddetails';
// import App from './GoodsDetails/rotate/TgetData';
// import App from './Ftest'
 import App from './Test/C_badge';
//  import App2 from './PersonSetting/XXSetting';
 import App2 from './PersonSetting/message';
// import './CSS/Center.css';
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
        <Route exact path="/" children={<Test />}  />

        <Route path="/PersonCenter" >
          <Container />
        </Route>
        <Route path="/Login" >
          <Login />
        </Route>
        <Route path="/Register" >
          <Register />
        </Route>
        <Route path="/GoodsDetails" >
          <GoodsDetails />
        </Route>
        <Route path="/ImedPurchase" >
          <ImedPurchases />
        </Route>
        <Route path="/XXYFReactManagement" >
          <Management />
        </Route>
        <Route path="/Shop" >
          <Shop />
        </Route>
        <Route path="/ShopView" >
          <ShopView />
        </Route>
        <Route path="/Test">
          <Test />
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
    // return(<App2/>)
  };
}