import React from 'react';
// import PropTypes from 'prop-types';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Divider from '@material-ui/core/Divider';
import Drawer from '@material-ui/core/Drawer';
import Hidden from '@material-ui/core/Hidden';
import IconButton from '@material-ui/core/IconButton';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import MailIcon from '@material-ui/icons/Mail';
// import MenuIcon from '@material-ui/icons/Menu';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles, useTheme } from '@material-ui/core/styles';
import ChevronRightOutlinedIcon from '@material-ui/icons/ChevronRightOutlined';
import MenuRoundedIcon from '@material-ui/icons/MenuRounded';
import Fab from '@material-ui/core/Fab';
import KeyboardArrowUpIcon from '@material-ui/icons/KeyboardArrowUp';
import Zoom from '@material-ui/core/Zoom';
import useScrollTrigger from '@material-ui/core/useScrollTrigger';
//个人中心模块接口
import {
    Route,
    Link,
    Switch,
    useRouteMatch,
    useLocation
  } from 'react-router-dom';
import App from './PTcontent';
import App2 from './../ShoppingCart/Container/ShoppingCart';
import App3 from './../GoodsDetails/allorder';
import './../CSS/Center.css';


const drawerWidth = 200;

const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
    overflowX: 'hidden',
    overflowY: 'hidden',
  },
  drawer: {
    [theme.breakpoints.up('sm')]: {
      width: drawerWidth,
      flexShrink: 0,
    },
  },
  appBar: {
    zIndex:1500,
    [theme.breakpoints.up('sm')]: {
      width: `calc(100% - ${drawerWidth}px)`,
      marginLeft: drawerWidth,
    },
  },
  menuButton: {
    marginRight: theme.spacing(2),
    [theme.breakpoints.up('sm')]: {
      display: 'none',
    },
  },
  toolbar: theme.mixins.toolbar,
  drawerPaper: {
    width: drawerWidth,
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
  fixscroll: {
    position: 'fixed',
    bottom: theme.spacing(2),
    right: theme.spacing(3),
  },
}));

function ScrollTop(props) {
  const { children, window } = props;
  const classes = useStyles();
  // Note that you normally won't need to set the window ref as useScrollTrigger
  // will default to window.
  // This is only being set here because the demo is in an iframe.
  const trigger = useScrollTrigger({
    target: window ? window() : undefined,
    disableHysteresis: true,
    threshold: 100,
  });

  const handleClick = event => {
    const anchor = (event.target.ownerDocument || document).querySelector('#back-to-top-anchor');
    if (anchor) {
      anchor.scrollIntoView({ behavior: 'smooth', block: 'center' });
    }
  };

  return (
    <Zoom in={trigger}>
      <div onClick={handleClick} role="presentation" className={classes.fixscroll}>
        {children}
      </div>
    </Zoom>
  );
}

function ResponsiveDrawer(props) {
  const { container } = props;
  const classes = useStyles();
  const theme = useTheme();
  const [mobileOpen, setMobileOpen] = React.useState(false);
  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };
  const ConT =[{name:'我的订单',id:'1',src:'/PersonCenter/order'},
  { name:'个人中心',id:'2',src:'/PersonCenter/'},
  {name:'购物车',id:'3',src:'/PersonCenter/Shoppingcart'}
];

  const drawer = (
    <div>
      <div className={classes.toolbar} >
      <Typography paragraph>
          潇湘药房
        </Typography>
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
            // <Link key={text.id} to={"/PersonCenter"+text.src}>
            // <ListItem  button  key={text.name} to={text.src}>
            //   <ListItemIcon >{text.id % 2 === 0 ? <InboxIcon /> : <MailIcon />} </ListItemIcon>
            //   <ListItemText  primary={text.src} />
            // </ListItem>
            // </Link>
            <MyCustomLink key={text.name} to={text.src} label={text.name} icon="1" />
          ))}
        </List>
    </div>
  );

  return (
    <div  className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            edge="start"
            onClick={handleDrawerToggle}
            className={classes.menuButton}
          >
            <MenuRoundedIcon />
          </IconButton>
          <Typography variant="h6" noWrap>
            潇湘药房
          </Typography>
        </Toolbar>
      </AppBar>
      <nav style={{display:'flex'}} className={classes.drawer} aria-label="mailbox folders">
        {/* The implementation can be swapped with js to avoid SEO duplication of links. */}
        <Hidden smUp implementation="css">
          <Drawer
            container={container}
            variant="temporary"
            anchor={theme.direction === 'rtl' ? 'right' : 'left'}
            open={mobileOpen}
            onClose={handleDrawerToggle}
            classes={{
              paper: classes.drawerPaper,
            }}
            ModalProps={{
              keepMounted: true, // Better open performance on mobile.
            }}
          >
            {drawer}
          </Drawer>
        </Hidden>
        <Hidden xsDown implementation="css">
          <Drawer
            classes={{
              paper: classes.drawerPaper,
            }}
            variant="permanent"
            open
          >
            {drawer}
          </Drawer>
        </Hidden>
      </nav>
      <main style={{position:'relative',top:90}} >
        <div id="back-to-top-anchor" />
        <Switch >                                {/*单选控制path=*有效*/}
          <Route exact path="/PersonCenter/">
                  <App />
          </Route>
          <Route path="/PersonCenter/order">
                  <App3 />
          </Route>
          <Route path="/PersonCenter/Shoppingcart">
                  <App2/>
          </Route>
          <Route path="*">
                <NoMatch />
          </Route>
        </Switch>
        <ScrollTop {...props}>
          <Fab color="secondary" size="small" aria-label="scroll back to top">
            <KeyboardArrowUpIcon />
          </Fab>
        </ScrollTop>
      </main>
      
    </div>
  );
}
function lClick(){
    // cPage = coponent;
    console.log("coponent");
  }

  function MyCustomLink({ label,icon,key, to, activeOnlyWhenExact }) {
    var iii=null;
    // var iconstyle = {fontSize: 50} 
    
    if(icon==="1"){
      iii=<InboxIcon 
      color='action'
      // className={iconstyle}
       />
      activeOnlyWhenExact=true;
    }else{
      iii=<MailIcon 
      color='action'
      // className={iconstyle}
      />
    }

    let match = useRouteMatch({
      path: to,
      exact: activeOnlyWhenExact,
      
    });
    
    return (
      <div key={key} style={{display:"flex"}} className={match ? "active" : ""}>
        {match && <ChevronRightOutlinedIcon style={{position:'relative',top:15}}/>}
        <Link to={to} style={{width:200}}>
             <ListItem  button  key={key} >
              {iii}
              <ListItemText style={{marginLeft:38}} primary={label} />
             </ListItem>
          </Link>
      </div>
    );
  }

  function NoMatch() {
    let location = useLocation();
    return (
      <div>
        <h3>
          No match for <code>{location.pathname}</code>
        </h3>
      </div>
    );
  }

 
  

export default ResponsiveDrawer;