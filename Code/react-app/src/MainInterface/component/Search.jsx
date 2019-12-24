import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import InputBase from '@material-ui/core/InputBase';
import IconButton from '@material-ui/core/IconButton';
import SearchIcon from '@material-ui/icons/Search';
import CardMedia from '@material-ui/core/CardMedia';
const useStyles = makeStyles(theme => ({
  root: {
    padding: '2px 4px',
    display: 'flex',
    alignItems: 'center',
    width: '550px',
    [theme.breakpoints.down('sm')]: {
      width: '390px',
    },
  },
  divs:{
    position:'relative',
    width:'100%',
     display:'flex',
     height:'106px',
    // background: '#EEEEEE',
  },
  div: {
    position:'relative',
    top:25,
    display:'flex',
    width: '600px',
    marginRight:'5%',
    float:'right',
    // background: '#FFEEEE',
    height:'80px',
    [theme.breakpoints.up('sm')]: {
      marginLeft:'13%',
    },
    [theme.breakpoints.down('md')]: {
      marginLeft:'15%',
    },
    
    [theme.breakpoints.down('sm')]: {
      
      height:'60px',
    width:'150px',
    marginRight:'0%',
    marginLeft:'1%',
    },
  },
  divsss:{
    position:'relative',
    top:35,
    height:'60px',
    marginRight:'35%',
    [theme.breakpoints.down('sm')]: {
      marginLeft:'10%',
    },
    [theme.breakpoints.down('xs')]: {
      marginLeft:'0%',
    },
    [theme.breakpoints.up('md')]: {
      marginLeft:'8%',
    },
  },
  input: {
    marginLeft: theme.spacing(1),
    flex: 1,
  },
  iconButton: {
    padding: 15,
  },
  divider: {
    height: 28,
    margin: 4,
  },
  media: {
    height:'80px',
    width:'170px',
    // top:'20px',
    
    link:{
      color:'#ff0000',
      
    },
    divss:{
      display:'flex',
      width: '600px',
      background:'#ff0000',
    }
  },
}));

export default function CustomizedInputBase() {
  const classes = useStyles();
  return (
  <div className={classes.divs}>
    <div className={classes.div}><CardMedia 
            className={classes.media}
            image="/Pic/logo.png"
            /></div>
    <div className={classes.divsss}>
    <Paper component="form" className={classes.root}>
      <InputBase
        className={classes.input}
        placeholder="请输入商品名、病症、人群等"
        inputProps={{ 'aria-label': 'search google maps' }}
      />
      <IconButton type="submit" className={classes.iconButton} aria-label="search">
        <SearchIcon />
      </IconButton> 
    </Paper>
    </div> 
  </div>
  );
}
