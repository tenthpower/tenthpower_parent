package com.tenthpower.controller;

import com.tenthpower.dto.article.ArticleVo;
import com.tenthpower.dto.article.ChannelVo;
import com.tenthpower.entity.Result;
import com.tenthpower.entity.StatusCode;
import com.tenthpower.service.ArticleService;
import com.tenthpower.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    /**
     * 查询全部列表
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public Result findAll() throws Exception {
        return new Result(true, StatusCode.OK,"查询成功",channelService.findAll() );
    }
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",channelService.findById(id));
    }
    /**
     * 增加
     * @param
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.POST)
    public Result add( @RequestBody ChannelVo channelVo){
        channelService.add(channelVo);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
    public Result update( @RequestBody ChannelVo channelVo,@PathVariable String
            id){
        channelVo.setId(id);
        channelService.update(channelVo);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id){
        channelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
