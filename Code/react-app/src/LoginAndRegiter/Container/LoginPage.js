import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Paper from '@material-ui/core/Paper';
import Box from '@material-ui/core/Box';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import cookie from 'react-cookies'
import { withRouter } from "react-router-dom"
// import { AxiosProvider, Request, Get, Delete, Head, Post, Put, Patch, withAxios,axios } from 'react-axios'
//  import requ from './admintest';
import axios from 'axios';
function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {'Copyright © '}
      <Link color="inherit" href="https://www.baidu.com/">
        潇湘药房
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}
//事件请求，不需要渲染
function test (props){
  if(document.getElementById("ad").value&&document.getElementById("pd").value)  {   
    axios.get(global.data.request+"BuyerLogin.action",
     {
      params: {
        BuyerNumber:document.getElementById("ad").value,
        BuyerPassword:document.getElementById("pd").value
      }
    })
    .then(function (response) {
      console.log(response)
      
      if(response.data.Buyer.length!==0){
        if(response.data.Buyer[0].buyerName===null){
          alert("欢迎登陆："+ "陌生人")
        }else{
          alert("欢迎登陆："+ response.data.Buyer[0].buyerName)
        }
        //浏览器存在周期
        cookie.save('userId', response.data.Buyer[0].idBuyer, { path: '/'})
        //仅在会话，标签栏
        sessionStorage.setItem("Umessage",response.data.Buyer[0].buyerNumber);
        // alert(global.data.localadd+'PersonCenter')
        window.location.href = global.data.localadd+"PersonCenter"
        // props.history.push("/PersonCenter")
      }
      else
      alert("message error")
    })
    .catch(function (error) {
      console.log(error);
    })
  }else{
    alert("input message")
  }
}

const useStyles = makeStyles(theme => ({
  root: {
    height: '100vh',
  },
  image: {
    backgroundImage: 'url(http://home.shundecity.com/attachment/201012/2/55466_12912750713jY8.jpg)',
    backgroundRepeat: 'no-repeat',
    backgroundColor: theme.palette.grey[50],
    backgroundSize: 'cover',
    backgroundPosition: 'center',
  },
  paper: {
    margin: theme.spacing(8, 4),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '75%', // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function SignInSide() {
  document.title = "登录";
  const classes = useStyles();
  return (
    <Grid container component="main" className={classes.root}>
      <CssBaseline />
      <Grid item xs={false} sm={4} md={7} className={classes.image} />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <div className={classes.paper}>
          <Avatar className={classes.avatar}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            登录
          </Typography>
          <form className={classes.form} noValidate>
            <TextField
              variant="outlined"
              margin="normal"
              require
              fullWidth
              label="用户名*"
              name="username"
              autoComplete="email"
              autoFocus
              id="ad"
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="密码"
              type="password"
              autoComplete="current-password"
              id="pd"
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="记住密码"
            />
            <Button
              // type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
              onClick={test}
            >
              登 录
            </Button>
            <Grid container>
              <Grid item xs>
                <Link href="#" variant="body2">
                  忘记密码？
                </Link>
              </Grid>
              <Grid item>
                <Link href="#" variant="body2">
                  {"没有账号？点此注册"}
                </Link>
              </Grid>
            </Grid>
            <Box mt={5}>
              <Copyright />
            </Box>
          </form>
        </div>
      </Grid>
    </Grid>
  );
}