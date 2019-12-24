import React from 'react';
import First from './component/First';
import FirstA from './component/First1';
import Second from './component/Second';
import Three from './component/Three';
import FirstBottomSmall from './component/FirstBottomSmall';
import Fab from '@material-ui/core/Fab';
import Zoom from '@material-ui/core/Zoom';
import useScrollTrigger from '@material-ui/core/useScrollTrigger';
import KeyboardArrowUpIcon from '@material-ui/icons/KeyboardArrowUp';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import Center from 'react-center';
import Typography from '@material-ui/core/Typography';
import LunBo1 from './component/lunbo1';
import TopSmall from './component/topSmall';
import SearchSmall from './component/searchSmall';
import SmallStrip from './component/smallStrip';
import SecondRightSmall from './component/SecondRightSmall';
import ThreeRightSmall from './component/ThreeRightSmall';
const defaultProps = {
    bgcolor: 'background.paper',
    // m: 0.1,
    border: 2,
  };

const useStyles = makeStyles(theme => ({
  divsss:{
    position:'relative',
    width:'100%',
    [theme.breakpoints.down('sm')]: {
      background:'#77DDFF',
    },
    
  },
  divsssss:{
    marginTop:20,
  },
    divBig:{
      display:'inline',
      position:'relative',
    width:'100%',
      [theme.breakpoints.down('sm')]: {
        display:'none',
      },
    },
    divSmall:{
      display:'none',
      [theme.breakpoints.down('sm')]: {
        display:'inline',
      },
    },
    divfirsta:{
      [theme.breakpoints.down('sm')]: {
        display:'none',
      },
    },
    divBox:{
        width:50,
        height:50,
    },
    divBoxaa:{
      width:50,
      height:50,
      background: '#0000ff',
  },
    divBoxa:{
      display:'none',
      width:50,
      height:50,
  },
  div:{
    width:50,
      height:20,
    marginTop:15,
  },
    fixscroll: {
      position: 'fixed',
      width:55.2,
      height:200,
    //   background: '#5e5e5e',
      bottom: theme.spacing(2),
      left: theme.spacing(3),
      marginLeft:'8%',
      marginBottom:'8%',

    },
    a:{
        textDecoration:'none',
        cursor:'pointer',
        color:'#0000ff',
    },
    link:{
      color:'#ffffff',
    }
  }));
  const diva={
      display:'none',
      width:50,
      height:50,
  }
  const divb={
        display:'block',
        width:53,
        height:50,
        cursor:'pointer',
  }
const divc={
  display:'none',
  width:50,
  height:50,
}
const divd={
    display:'block',
    width:53,
    height:50,
    cursor:'pointer',
}

function ScrollTop(props) {
    const { children, window } = props;
    const classes = useStyles();
    const [Boxa,setBoxa] = React.useState(diva);
    const [Boxb,setBoxb] = React.useState(divb);
    const [Boxc,setBoxc] = React.useState(divc);
    const [Boxd,setBoxd] = React.useState(divd);
    // const [Box,setBox] = React.useState(divBoxa);
    // Note that you normally won't need to set the window ref as useScrollTrigger
    // will default to window.
    // This is only being set here because the demo is in an iframe.
    const trigger = useScrollTrigger({
      target: window ? window() : undefined,
      disableHysteresis: true,
      threshold: 668,
      
    });
  
    const handleClick = event => {
      const anchor = (event.target.ownerDocument || document).querySelector('#back-to-top-anchor1');
      if (anchor) {
        anchor.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    };
    const handleClick1 = event => {
      const anchor = (event.target.ownerDocument || document).querySelector('#back-to-top-anchor2');
      if (anchor) {
        anchor.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    };
    return (
      <Zoom in={trigger} >
        <div  role="presentation" className={classes.fixscroll}>
          {/* {children} */}
          <div className={classes.divBox}><a className={classes.a} href="#back-to-top-anchor">
          <Box className={classes.divBox}  borderColor="#0000ff" {...defaultProps}>
              <Center>今日</Center>
              <Center>限时购</Center>
          </Box></a></div>
          <div style={Boxa} onClick={handleClick} onMouseOut={()=>(setBoxa(diva),setBoxb(divb))}>
            <Box className={classes.divBoxaa} borderColor="#0000ff" {...defaultProps} >
              <div className={classes.link}><Center><Typography noWrap >家庭</Typography></Center>
              <Center> <Typography noWrap >常备药</Typography></Center>
              </div>
            </Box>
          </div>
          <div style={Boxb} onMouseOver={()=>(setBoxa(divb),setBoxb(diva))} >
            <Box className={classes.divBox} borderColor="#0000ff" {...defaultProps} >
              <div className={classes.div}><Center><Typography noWrap >1F</Typography></Center></div>
            </Box>
          </div>
          <div style={Boxc} onClick={handleClick1} onMouseOut={()=>(setBoxc(divc),setBoxd(divd))}>
            <Box className={classes.divBoxaa} borderColor="#0000ff" {...defaultProps} >
              <div className={classes.link}><Center><Typography noWrap >专科</Typography></Center>
              <Center> <Typography noWrap >用药</Typography></Center>
              </div>
            </Box>
          </div>
          <div style={Boxd} onMouseOver={()=>(setBoxc(divd),setBoxd(divc))} >
            <Box className={classes.divBox} borderColor="#0000ff" {...defaultProps} >
              <div className={classes.div}><Center><Typography noWrap >2F</Typography></Center></div>
            </Box>
          </div>
        </div>
      </Zoom>
    );
}
const Total  = props =>{
  const [All,setAll] = React.useState(
    [{
        contT://第二层中间最大的图片
        [
            {to:'www.baidu.com',imgsrc:'/Pic/shen.png'}
        ],
        contA://第二层右侧两个大的图片
        [
                {to:'www.baidu.com',imgsrc:'/Pic/shenzuo.png'},
                {to:'www.baidu.com',imgsrc:'/Pic/shenyou.png'}
        ],
        contB://第二层五个小的图片，label列最多四个字，money列要“¥  44.00”格式
            [
                {to:'www.baidu.com',imgsrc:'/Pic/xiao7.png',money:'¥  44.00',label:'益安宁丸'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao2.png',money:'¥  45.00',label:'五子衍宗'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao3.png',money:'¥  46.00',label:'红金消结'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao4.png',money:'¥  47.00',label:'福牌阿胶'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao5.png',money:'¥  48.00',label:'奥利司他'}
        ],
        contST://手机端第二层中间最大的图片
        [
            {to:'www.baidu.com',imgsrc:'/Pic/shen.png'}
        ],
        contSA://手机端第二层右侧的图片
        [
                {to:'www.baidu.com',imgsrc:'/Pic/shenzuo.png'},
        ],
        conta://手机端第二层三个个小的图片，label列最多四个字，money列要“¥  44.00”格式
        [
          {to:'www.baidu.com',imgsrc:'/Pic/xiao7.png',money:'¥  44.00',label:'益安宁丸'},
          {to:'www.baidu.com',imgsrc:'/Pic/xiao2.png',money:'¥  45.00',label:'五子衍宗'},
          {to:'www.baidu.com',imgsrc:'/Pic/xiao3.png',money:'¥  46.00',label:'红金消结'}
     ],
        contSAT://手机端第三层中间最大的图片
        [
            {to:'www.baidu.com',imgsrc:'/Pic/shen.png'}
        ],
        contSAA://手机端第三层右侧的图片
        [
                {to:'www.baidu.com',imgsrc:'/Pic/shenzuo.png'},
        ],
        contaA://手机端第三层三个个小的图片，label列最多四个字，money列要“¥  44.00”格式
        [
          {to:'www.baidu.com',imgsrc:'/Pic/xiao7.png',money:'¥  44.00',label:'益安宁丸'},
          {to:'www.baidu.com',imgsrc:'/Pic/xiao2.png',money:'¥  45.00',label:'五子衍宗'},
          {to:'www.baidu.com',imgsrc:'/Pic/xiao3.png',money:'¥  46.00',label:'红金消结'}
    ],
        contX://第3层中间最大的图片
        [
            {to:'www.baidu.com',imgsrc:'/Pic/shen.png'}
        ],
        contY://第3层右侧两个大的图片
        [
                {to:'www.baidu.com',imgsrc:'/Pic/shenzuo.png'},
                {to:'www.baidu.com',imgsrc:'/Pic/shenyou.png'}
        ],
        contZ://第3层五个小的图片，label列最多四个字，money列要“¥  44.00”格式
            [
                {to:'www.baidu.com',imgsrc:'/Pic/xiao5.png',money:'¥  144.00',label:'益安宁丸'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao4.png',money:'¥ 145.00',label:'五子衍宗'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao2.png',money:'¥  1146.00',label:'红金消结'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao3.png',money:'¥ 147.00',label:'福牌阿胶'},
                {to:'www.baidu.com',imgsrc:'/Pic/xiao7.png',money:'¥  148.00',label:'奥利司他'}
        ],
        contC://今日限购四个
          [
                {to:'//www.baidu.com',imgsrc:'/Pic/yao1.png'},
                {to:'//www.baidu.com',imgsrc:'/Pic/yao2.png'},
                {to:'//www.baidu.com',imgsrc:'/Pic/yao3.png'},
                {to:'//www.baidu.com',imgsrc:'/Pic/yao4.png'}
          ],
        contD://长条广告
          [
            {to:'www.baidu.com',imgsrc:'/Pic/lang.png'}
          ],
        contF://轮播图
          [
            {to:'//www.baidu.com',imgsrc:'/Pic/12.png'},
            {to:'//www.baidu.com',imgsrc:'/Pic/xiao2.png'},
            {to:'//www.baidu.com',imgsrc:'/Pic/xiao3.png'},
            {to:'//www.baidu.com',imgsrc:'/Pic/xiao4.png'},
            {to:'//www.baidu.com',imgsrc:'/Pic/xiao5.png'},
            {to:'//www.baidu.com',imgsrc:'/Pic/xiao2.png'},
          ]
    }]
);
const classes = useStyles();
    return(
        <div className={classes.divsss}>
          <div className={classes.divSmall}>
            <TopSmall/>
            <SearchSmall/>
            <SmallStrip/>  
            <LunBo1 name={All[0].contF}/>
            <FirstBottomSmall className={classes.divsssss} name={All[0].contC}/>
            <SecondRightSmall className={classes.divsssss} name={All}/>
            &nbsp;
            <ThreeRightSmall name={All}/>
          </div>
          <div className={classes.divBig}>
            <div> <First name={All[0].contF}/></div>
            <div id="back-to-top-anchor" className={classes.divfirsta}><FirstA name={All[0].contC} name1={All[0].contD}/></div>
            <div id="back-to-top-anchor1" className={classes.divfirsta}><Second name={All}/></div>
            <div id="back-to-top-anchor2" className={classes.divfirsta}><Three name={All}/></div>
              <ScrollTop {...props}>
                <Fab color="secondary" size="small" aria-label="scroll back to top">
                    <KeyboardArrowUpIcon />
                </Fab>
            </ScrollTop>
          </div>
          <div>

          </div>
        </div>
    );
  }
export default Total;