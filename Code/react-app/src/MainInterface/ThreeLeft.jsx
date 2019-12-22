import React from 'react';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import Center from 'react-center';
import { Link } from '@material-ui/core';
const defaultProps = {
    bgcolor: 'background.paper',
    // m: 1,
    border: 1,
  };
const useStyles = makeStyles(theme => ({
    div:{
        width:225,
        height:610,
        marginLeft:'14%',
        marginTop:40,
    },
    divtop:{
        display:'flex',
        width:225,
        height:110,
        background:'#FFA27A',
    },
    divtop1:{
        marginLeft:30,
        marginTop:40,
    },
    divbig:{
        display:'flex',
        width:225,
        height:62.5,
    },
    divsmall:{
        width:112.5,
        height:62.5,
    },
    link:{
        color:'#ffffff',
    },
    divsmall1:{
        marginTop:20,
    }
  }));
const linkss={
    color:'#ff0000',
}
const links={
    color:'#000000',
}
export default function Test(props){
    const classes = useStyles();
    const [Links1,setLinks1] = React.useState(links);
    const [Links2,setLinks2] = React.useState(links);
    const [Links3,setLinks3] = React.useState(links);
    const [Links4,setLinks4] = React.useState(links);
    const [Links5,setLinks5] = React.useState(links);
    const [Links6,setLinks6] = React.useState(links);
    const [Links7,setLinks7] = React.useState(links);
    const [Links8,setLinks8] = React.useState(links);
    const [Links9,setLinks9] = React.useState(links);
    const [LinksA,setLinksA] = React.useState(links);
    const [LinksB,setLinksB] = React.useState(links);
    const [LinksC,setLinksC] = React.useState(links);
    const [LinksD,setLinksD] = React.useState(links);
    const [LinksE,setLinksE] = React.useState(links);
    const [LinksF,setLinksF] = React.useState(links);
    const [LinksG,setLinksG] = React.useState(links);
    return(
        <div className={classes.div}>
            <div className={classes.divtop}>
                <div className={classes.divtop1}><Typography noWrap className={classes.link} variant="h5">2F&nbsp;&nbsp;&nbsp;专科用药</Typography></div>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks1(linkss))} onMouseOut={()=>(setLinks1(links))}>
                           <Link style={Links1} href="//www.baidu.com" ><Typography noWrap >性功能障碍</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                        <div className={classes.divsmall1}  onMouseOver={()=>(setLinks2(linkss))} onMouseOut={()=>(setLinks2(links))}>
                           <Link style={Links2} href="//www.baidu.com" ><Typography noWrap >乙肝</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks3(linkss))} onMouseOut={()=>(setLinks3(links))}>
                           <Link style={Links3} href="//www.baidu.com" ><Typography noWrap >风湿类风湿</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks4(linkss))} onMouseOut={()=>(setLinks4(links))}>
                           <Link style={Links4} href="//www.baidu.com" ><Typography noWrap >高血压</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks5(linkss))} onMouseOut={()=>(setLinks5(links))}>
                           <Link style={Links5} href="//www.baidu.com" ><Typography noWrap >抑郁症</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks6(linkss))} onMouseOut={()=>(setLinks6(links))}>
                           <Link style={Links6} href="//www.baidu.com" ><Typography noWrap >哮喘</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks7(linkss))} onMouseOut={()=>(setLinks7(links))}>
                           <Link style={Links7} href="//www.baidu.com" ><Typography noWrap >冠心病</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks8(linkss))} onMouseOut={()=>(setLinks8(links))}>
                           <Link style={Links8} href="//www.baidu.com" ><Typography noWrap >糖尿病</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinks9(linkss))} onMouseOut={()=>(setLinks9(links))}>
                           <Link style={Links9} href="//www.baidu.com" ><Typography noWrap >银屑病</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksA(linkss))} onMouseOut={()=>(setLinksA(links))}>
                           <Link style={LinksA} href="//www.baidu.com" ><Typography noWrap >关节炎</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksB(linkss))} onMouseOut={()=>(setLinksB(links))}>
                           <Link style={LinksB} href="//www.baidu.com" ><Typography noWrap >癫痫</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksC(linkss))} onMouseOut={()=>(setLinksC(links))}>
                           <Link style={LinksC} href="//www.baidu.com" ><Typography noWrap >脱发</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksD(linkss))} onMouseOut={()=>(setLinksD(links))}>
                           <Link style={LinksD} href="//www.baidu.com" ><Typography noWrap >痛风</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksE(linkss))} onMouseOut={()=>(setLinksE(links))}>
                           <Link style={LinksE} href="//www.baidu.com" ><Typography noWrap >帕金森</Typography></Link>
                        </div>
                    </Center> 
                </Box>
            </div>
            <div className={classes.divbig}>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksF(linkss))} onMouseOut={()=>(setLinksF(links))}>
                           <Link style={LinksF} href="//www.baidu.com" ><Typography noWrap >精神分裂症</Typography></Link>
                        </div>
                    </Center> 
                </Box>
                <Box className={classes.divsmall} borderColor="#DDDDDD" {...defaultProps}>
                   <Center >
                       <div className={classes.divsmall1}  onMouseOver={()=>(setLinksG(linkss))} onMouseOut={()=>(setLinksG(links))}>
                            <Link style={LinksG} href="//www.baidu.com" ><Typography noWrap >中风</Typography></Link>
                       </div>
                    </Center> 
                </Box>
            </div>
        </div>
    );
  }

