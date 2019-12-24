import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import LunBO from './lunBo';
import Typography from '@material-ui/core/Typography';
import Center from 'react-center';
import { Link } from '@material-ui/core';
const useStyles = makeStyles(theme => ({
    divset:{
        [theme.breakpoints.down('sm')]: {
            display:'none',
        },
    },
    divsetaa:{
         display:'none',
         position:'relative',
            width:'100%',
        [theme.breakpoints.down('sm')]: {
            display:'inline',
            position:'relative',
            width:'100%',
        },
    },
    div: {
        width:166,
        height:468,
        marginLeft:'14%', 
        
        [theme.breakpoints.down('md')]: {

            marginLeft:'0%',
            width:166,
            height:468,
            
        },
        [theme.breakpoints.down('sm')]: {
            marginLeft:'0%',
            width:166,
            height:468,
            display:'none',
        },
      },
      divss:{
        width:'100%',
        display:'flex',
        height:468,
    },
    divnan:{
        display:'flex',
        marginTop:5,
    },
    divssss:{
        width:290 ,
        height:468,
        
    },
    divsss:{
        display:'flex',
        marginLeft:'15px',
        marginTop:'15px',
        [theme.breakpoints.down('sm')]: {
            display:'none',
        },
    },
    divtu:{
        marginLeft:'50px',
        marginTop:'45px',
        [theme.breakpoints.down('sm')]: {
            display:'none',
        },
    },
    divb:{
        width:'166px',
        height:23.4,
        marginTop:'11.7px',
    },
    divone:{
        display:'flex',
        width:945,
        height:110,
        marginTop:25,
    },
    divtwo:{
        width:290,
        height:110,
        marginLeft:25,
    },
    linkss:{
        color:'#000000',
    },
    links:{
        color:'#ff0000',
    }
  }));
const first ={
    display:'flex',
    width:166,
    height:46.8,
    background: '#5e5e5e',
}
const second ={
    display:'flex',
    width:166,
    height:46.8,
    background: '#ffffff',
}
const front ={
    background: '#ffffff',
    width:820,
    height:450,
}
const behind ={
    display:"none",
    width:820,
    height:450,
    marginLeft:'15px',
    marginTop:'19px',
}
const right ={
    width:290,
    height:468,
    marginLeft:'15px',
}
const right1 ={
    display:"none",
    width:290,
    height:468,
}
const one ={
    display:"none",
    width:1100,
    height:468,
}
const one1 ={
    width:1100,
    height:468,
}
const word = {
    color:'#ffffff',
}
const word1 = {
    color:'#000000',
}
// var cstyle=second;
export default function Test(props){
    const classes = useStyles();
    const [Cstyle,setCstyle] = React.useState(first);
    const [Astyle,setAstyle] = React.useState(first);
    const [Bstyle,setBstyle] = React.useState(first);
    const [Dstyle,setDstyle] = React.useState(first);
    const [Estyle,setEstyle] = React.useState(first);
    const [Fstyle,setFstyle] = React.useState(first);
    const [Gstyle,setGstyle] = React.useState(first);
    const [Hstyle,setHstyle] = React.useState(first);
    const [Istyle,setIstyle] = React.useState(first);
    const [Jstyle,setJstyle] = React.useState(first);
    const [Lunbo,setLunbo] = React.useState(front);
    const [Right,setRight] = React.useState(right);
    const [One,setOne] = React.useState(one);
    const [Two,setTwo] = React.useState(one);
    const [Three,setThree] = React.useState(one);
    const [Four,setFour] = React.useState(one);
    const [Five,setFive] = React.useState(one);
    const [Six,setSix] = React.useState(one);
    const [Senven,setSenven] = React.useState(one);
    const [Eight,setEight] = React.useState(one);
    const [Nine,setNine] = React.useState(one);
    const [Ten,setTen] = React.useState(one);
    const [Word1,setWord1] = React.useState(word);
    const [Word2,setWord2] = React.useState(word);
    const [Word3,setWord3] = React.useState(word);
    const [Word4,setWord4] = React.useState(word);
    const [Word5,setWord5] = React.useState(word);
    const [Word6,setWord6] = React.useState(word);
    const [Word7,setWord7] = React.useState(word);
    const [Word8,setWord8] = React.useState(word);
    const [Word9,setWord9] = React.useState(word);
    const [WordA,setWordA] = React.useState(word);
    // const Set = props =>{
        // setCstyle(second);
    // }
    return(
        <div className={classes.divss}>
            <div className={classes.div}> 
                <div style={Cstyle} onMouseOver={()=>(setCstyle(second),setLunbo(behind),setRight(right1),setOne(one1),setWord1(word1))} onMouseOut={()=>(setCstyle(first),setLunbo(front),setRight(right),setOne(one),setWord1(word))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word1} >中西药品</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Astyle} onMouseOver={()=>(setAstyle(second),setWord2(word1),setLunbo(behind),setRight(right1),setTwo(one1))} onMouseOut={()=>(setAstyle(first),setWord2(word),setLunbo(front),setRight(right),setTwo(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word2}>营养保健</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Bstyle} onMouseOver={()=>(setBstyle(second),setWord3(word1),setLunbo(behind),setRight(right1),setThree(one1))} onMouseOut={()=>(setBstyle(first),setWord3(word),setLunbo(front),setRight(right),setThree(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word3}>维生素钙</Typography> 
                        </Center>
                    </div>
                </div>
                <div style={Dstyle} onMouseOver={()=>(setDstyle(second),setWord4(word1),setLunbo(behind),setRight(right1),setFour(one1))} 
                                    onMouseOut={()=>(setDstyle(first),setWord4(word),setLunbo(front),setRight(right),setFour(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word4}>隐形眼镜</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Estyle} onMouseOver={()=>(setEstyle(second),setWord5(word1),setLunbo(behind),setRight(right1),setFive(one1))} 
                                    onMouseOut={()=>(setEstyle(first),setWord5(word),setLunbo(front),setRight(right),setFive(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word5}>医疗器械</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Fstyle} onMouseOver={()=>(setFstyle(second),setWord6(word1),setLunbo(behind),setRight(right1),setSix(one1))} 
                                    onMouseOut={()=>(setFstyle(first),setWord6(word),setLunbo(front),setRight(right),setSix(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word6}>健康电器</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Gstyle} onMouseOver={()=>(setGstyle(second),setWord7(word1),setLunbo(behind),setRight(right1),setSenven(one1))} 
                                    onMouseOut={()=>(setGstyle(first),setWord7(word),setLunbo(front),setRight(right),setSenven(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word7}>美妆个护</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Hstyle} onMouseOver={()=>(setHstyle(second),setWord8(word1),setLunbo(behind),setRight(right1),setEight(one1))} 
                                    onMouseOut={()=>(setHstyle(first),setWord8(word),setLunbo(front),setRight(right),setEight(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word8}>成人用品</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Istyle} onMouseOver={()=>(setIstyle(second),setWord9(word1),setLunbo(behind),setRight(right1),setNine(one1))} 
                                    onMouseOut={()=>(setIstyle(first),setWord9(word),setLunbo(front),setRight(right),setNine(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={Word9}>母婴专区</Typography>
                        </Center>
                    </div>
                </div>
                <div style={Jstyle} onMouseOver={()=>(setJstyle(second),setWordA(word1),setLunbo(behind),setRight(right1),setTen(one1))} 
                                    onMouseOut={()=>(setJstyle(first),setWordA(word),setLunbo(front),setRight(right),setTen(one))}>
                    <div className={classes.divb}>
                        <Center>
                                <Typography noWrap style={WordA}>体验专区</Typography>
                        </Center>
                    </div>
                </div>
            </div>
            <div style={Lunbo}>
                <div className={classes.divset}><LunBO name={props.name}/></div>
                
            </div>
            <div style={Right}>
               <div className={classes.divsss}>
                   <Typography noWrap >
                       在线问诊
                   </Typography>
               </div>
               <div className={classes.divsss}>
                   <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           男科
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           妇科
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           糖尿病
                        </Typography>
                    </Link>&nbsp;>
                </div>
                <div className={classes.divsss}>
                   <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           心脑血管
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           肝胆科
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           神经科
                        </Typography>
                    </Link>&nbsp;>
                </div>
                <div className={classes.divsss}>
                   <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           肿瘤
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           消化科
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           风湿骨科
                        </Typography>
                    </Link>&nbsp;>
                </div>
                <div className={classes.divsss}>
                   <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           皮肤性病
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           眼耳鼻喉
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           呼吸科
                        </Typography>
                    </Link>&nbsp;>
                </div>
                <div className={classes.divsss}>
                   <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           滋补保健
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           散光验配
                        </Typography>
                    </Link>&nbsp;>&nbsp;&nbsp;
                    <Link className={classes.linkss} href="//www.baidu.com" >
                       <Typography noWrap >
                           医疗器械
                        </Typography>
                    </Link>&nbsp;>
                </div>
                <div className={classes.divsss}>
                   <Typography noWrap >
                       医生问诊
                   </Typography>
               </div>
               <div className={classes.divtu}>
               <Link href="//www.baidu.com" ><img alt="loading" src="/Pic/xin.png"/></Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<Link href="//www.baidu.com" ><img alt="loading" src="/Pic/er.png"/></Link>
               </div>
               <div className={classes.divsss}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <Typography noWrap >
                       综合门诊
                   </Typography>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <Typography noWrap >
                       儿科
                   </Typography>
               </div>
            </div>
            <div style={One} onMouseOver={()=>(setCstyle(second),setLunbo(behind),setRight(right1),setOne(one1),setWord1(word1))} 
                                onMouseOut={()=>(setCstyle(first),setLunbo(front),setRight(right),setOne(one),setWord1(word))}>
                <div className={classes.divone}>
                    <div className={classes.divtwo}>
                        <div><Typography noWrap>男科疾病</Typography></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.links}><Typography noWrap >阳痿早泄</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>男性不育症</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>前列腺炎</Typography></Link></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.linkss}><Typography noWrap>肾病</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>泌尿系统疾病</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>补肾</Typography></Link></div>
                    </div>
                    <div className={classes.divtwo}>
                        <div><Typography noWrap>风湿骨科</Typography></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.links}><Typography noWrap >阳痿早泄</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>骨关节炎</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>跌打骨伤</Typography></Link></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.linkss}><Typography noWrap>腰椎病</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>骨质疏松</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>痛风</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>外用贴膏</Typography></Link></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.linkss}><Typography noWrap >器官移植</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>骨质增生</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>股骨头坏死</Typography></Link></div>
                    </div>
                </div>
                <div className={classes.divone}>
                    <div className={classes.divtwo}>
                        <div><Typography noWrap>滋补调养</Typography></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.links}><Typography noWrap >风湿类风湿</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>男性不育症</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>前列腺炎</Typography></Link></div>
                        <div className={classes.divnan}> <Link href="//www.baidu.com" className={classes.linkss}><Typography noWrap>肾病</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>泌尿系统疾病</Typography></Link>&nbsp;丨&nbsp;<Link className={classes.linkss} href="//www.baidu.com" ><Typography noWrap>补肾</Typography></Link></div>
                    </div>
                </div>
            </div>
            <div style={Two} onMouseOver={()=>(setAstyle(second),setWord2(word1),setLunbo(behind),setRight(right1),setTwo(one1))} 
                                onMouseOut={()=>(setAstyle(first),setWord2(word),setLunbo(front),setRight(right),setTwo(one))}>
                &nbsp;222
            </div>
            <div style={Three} onMouseOver={()=>(setBstyle(second),setWord3(word1),setLunbo(behind),setRight(right1),setThree(one1))} 
                                onMouseOut={()=>(setBstyle(first),setWord3(word),setLunbo(front),setRight(right),setThree(one))}>
                &nbsp;333
            </div>
            <div style={Four} onMouseOver={()=>(setDstyle(second),setWord4(word1),setLunbo(behind),setRight(right1),setFour(one1))} 
                                onMouseOut={()=>(setDstyle(first),setWord4(word),setLunbo(front),setRight(right),setFour(one))}>
                &nbsp;444
            </div>
            <div style={Five} onMouseOver={()=>(setEstyle(second),setWord5(word1),setLunbo(behind),setRight(right1),setFive(one1))} 
                                onMouseOut={()=>(setEstyle(first),setWord5(word),setLunbo(front),setRight(right),setFive(one))}>
                &nbsp;5
            </div>
            <div style={Six} onMouseOver={()=>(setFstyle(second),setWord6(word1),setLunbo(behind),setRight(right1),setSix(one1))}
                                onMouseOut={()=>(setFstyle(first),setWord6(word),setLunbo(front),setRight(right),setSix(one))}>
                &nbsp;6
            </div>
            <div style={Senven} onMouseOver={()=>(setGstyle(second),setWord7(word1),setLunbo(behind),setRight(right1),setSenven(one1))} 
                                onMouseOut={()=>(setGstyle(first),setWord7(word),setLunbo(front),setRight(right),setSenven(one))}>
                &nbsp;7
            </div>
            <div style={Eight} onMouseOver={()=>(setHstyle(second),setWord8(word1),setLunbo(behind),setRight(right1),setEight(one1))} 
                               onMouseOut={()=>(setHstyle(first),setWord8(word),setLunbo(front),setRight(right),setEight(one))}>
                &nbsp;8
            </div>
            <div style={Nine} onMouseOver={()=>(setIstyle(second),setWord9(word1),setLunbo(behind),setRight(right1),setNine(one1))} 
                              onMouseOut={()=>(setIstyle(first),setWord9(word),setLunbo(front),setRight(right),setNine(one))}>
                &nbsp;
            </div>
            <div style={Ten} onMouseOver={()=>(setJstyle(second),setWordA(word1),setLunbo(behind),setRight(right1),setTen(one1))}
                             onMouseOut={()=>(setJstyle(first),setWordA(word),setLunbo(front),setRight(right),setTen(one))}>
                &nbsp;10
            </div>
        </div>
    );
  }
