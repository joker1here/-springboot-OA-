package com.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.RelationDao;
import com.ssmp.pojo.Relation;
import com.ssmp.service.IRelationService;
import org.springframework.stereotype.Service;

@Service
public class RelationServiceImpl extends ServiceImpl<RelationDao, Relation> implements IRelationService {
}
