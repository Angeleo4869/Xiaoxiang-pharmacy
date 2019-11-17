import React from 'react';
import clsx from 'clsx';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import MailIcon from '@material-ui/icons/Mail';
import Switch from '@material-ui/core/Switch';
import Avatar from '@material-ui/core/Avatar';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

import App from './PTcontent';
import App2 from './../Test/App2';
import App3 from './../Test/App3';

import './../CSS/Center.css';

const drawerWidth = 240;
//css样式
const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen, 
    }),
  },
  menuButton: {
    marginRight: 36,
  },
  hide: {
    display: 'none',
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
    whiteSpace: 'nowrap',
  },
  drawerOpen: {
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  drawerClose: {
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    overflowX: 'hidden',
    width: theme.spacing(7) + 1,
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing(9) + 1,
    },
  },
  toolbar: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end',
    padding: theme.spacing(0, 1),
    ...theme.mixins.toolbar,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
  TSwitch: {
    forecolor: 'blue',
    right: 1,
    position: 'absolute',
  },
  Tavatar: {
    right: 50,
    position: 'absolute',
  }
}));

// var cPage = true;//中心界面显示面板内容

export default function MiniDrawer(){//函数组件，携带父级传的参数'name'
  const classes = useStyles();
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);
  const handleChange = name => event => {
  setState({ ...state, [name]: event.target.checked });  
};

const handleDrawerOpen = () => {
  setOpen(true);
};

const handleDrawerClose = () => {
  setOpen(false);
};
const [state, setState] = React.useState({
  checkedA: true,
  checkedB: true,
});
const ConT =[{name:'All mail',id:'1',src:'/about'},
              { name:'Trash',id:'2',src:'/home'},
              {name:'Spam',id:'3',src:'/release'}
            ];

  return (
  <Router>
    <div className={classes.root}>
      <CssBaseline />
      <AppBar
        position="fixed"
        className={clsx(classes.appBar, {
          [classes.appBarShift]: open,
        })}
      >
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            edge="start"
            className={clsx(classes.menuButton, {
              [classes.hide]: open,
            })}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" noWrap>
            Person Center
          </Typography>

          <Switch
            className={classes.TSwitch}
            checked={state.checkedA}
            onChange={handleChange('checkedA')}
            value="checkedA"
            inputProps={{ 'aria-label': 'secondary checkbox' }}
          />
          <Avatar alt="not" src="/Pic/D1.jpg" className={classes.Tavatar} />
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        className={clsx(classes.drawer, {
          [classes.drawerOpen]: open,
          [classes.drawerClose]: !open,
        })}
        classes={{
          paper: clsx({
            [classes.drawerOpen]: open,
            [classes.drawerClose]: !open,
          }),
        }}
        open={open}
      >
        <div className={classes.toolbar}>
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === 'rtl' ? <ChevronRightIcon /> : <ChevronLeftIcon />}
          </IconButton>
        </div>
        <Divider />
        <List>
          {['first', 'Starred', 'Send email', 'Drafts'].map((text, index) => (
            <ListItem onClick={lClick} button key={text}>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItem>
          ))}
        </List>
        <Divider />
        {/* mapy映射关系详细 */}
        <List>
          {ConT.map((text) => (
            <Link key={text.id} to={"/PersonCenter"+text.src}>
            <ListItem  button  key={text.name} to={text.src}>
              <ListItemIcon >{text.id % 2 === 0 ? <InboxIcon /> : <MailIcon />} </ListItemIcon>
              <ListItemText  primary={text.src} />
            </ListItem>
            </Link>
          ))}
        </List>
      </Drawer>
      
      <main style={{position:'relative',top:90}} >
        <Route path="/PersonCenter/about">
              <App3 />
        </Route>
        <Route path="/PersonCenter/home">
              <App />
        </Route>
        <Route path="/PersonCenter/release">
          <App2/>
        </Route>
      </main>
      
   </div>
  </Router>
  );
}

function lClick(){
  // cPage = coponent;
  console.log("coponent");
}


