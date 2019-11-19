import React from 'react';
import ReactDOM from 'react-dom';
import Welcome from './ES6Clare';
// import Container from './PersonCenter/PersonCenter.jsx';
// import Container from './GoodsDetails/gooddetails';
// import Container from './GoodsDetails/rotate/test'
import Container from './PersonCenter/drawer';
// import Container from './GoodsDetails/Tabs';

import {
    BrowserRouter as Router,
    Switch,
    Route,
  } from 'react-router-dom';

  function RootRouter() {
    return (
        <Router>
        <Switch >
          <Route exact path="/" children={<Welcome />} />
          <Route path="/PersonCenter">
          <Container />
          </Route>
         
        </Switch>      
        </Router>
    );
  }

ReactDOM.render(<RootRouter />, document.getElementById('food'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA

