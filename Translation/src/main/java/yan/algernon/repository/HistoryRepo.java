package yan.algernon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yan.algernon.domain.TranslateHistory;

@Repository
public interface HistoryRepo extends CrudRepository<TranslateHistory,Integer>
{
}
