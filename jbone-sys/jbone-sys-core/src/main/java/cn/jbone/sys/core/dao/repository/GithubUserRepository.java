package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.GithubUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubUserRepository extends JpaRepository<GithubUserEntity,Integer>,JpaSpecificationExecutor<GithubUserEntity> {
    GithubUserEntity findByGithubId(long githubId);
}
