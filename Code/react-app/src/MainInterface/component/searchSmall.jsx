import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import InputBase from '@material-ui/core/InputBase';
import IconButton from '@material-ui/core/IconButton';
import SearchIcon from '@material-ui/icons/Search';
const useStyles = makeStyles(theme => ({
  root: {
    position:'relative',
    padding: '2px 4px',
    display: 'flex',
    alignItems: 'center',
    width: '100%',
  },
  divs:{
    position:'relative',
     display:'flex',
     width:'100%',
    // background: '#EEEEEE',
  },
  div: {
    position:'relative',
    top:25,
    display:'flex',
    width: '100%',
    // marginLeft:'5%',
    // background: '#FFEEEE',
    height:'80px',
  },
  divsss:{
    position:'relative',
    width:'100%',
    height:'60px',
  },
  input: {
    position:'relative',
    width:'90%', 
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
