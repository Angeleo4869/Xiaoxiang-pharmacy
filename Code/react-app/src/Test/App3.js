import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
// import AppBar from '@material-ui/core/AppBar';
// import Toolbar from '@material-ui/core/Toolbar';
// import Typography from '@material-ui/core/Typography';
 import Button from '@material-ui/core/Button';
// import IconButton from '@material-ui/core/IconButton';
// import MenuIcon from '@material-ui/icons/Menu';
import {
  Route,
  Link,
} from 'react-router-dom';
// import App from './App';
// import App2 from './App2';
const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export default function ButtonAppBar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Link key={123} to={"/PersonCenter/about/new"}>link</Link>
      <Link key={1123} to={"/PersonCenter/about/old"}>link</Link>
      
      <div>
      
        <switch>
        
        <Route exact path="/PersonCenter/about/old" >
            <Button>hello</Button>
        </Route>
        <Route path="/PersonCenter/about/new" >
            <Button>world</Button>
        </Route>
        </switch>
      
      </div>
      
    </div>
  );
}